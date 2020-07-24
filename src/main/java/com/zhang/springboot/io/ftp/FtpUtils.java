package com.zhang.springboot.io.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FtpUtils {
    private static final Log log = LogFactory.getLog(FtpUtils.class);

    /**
     * 本地字符编码
     **/
    private static String localCharset = "GBK";

    /**
     * FTP协议里面，规定文件名编码为iso-8859-1
     **/
    private static String serverCharset = "ISO-8859-1";

    /**
     * UTF-8字符编码
     **/
    private static final String CHARSET_UTF8 = "UTF-8";

    /**
     * OPTS UTF8字符串常量
     **/
    private static final String OPTS_UTF8 = "OPTS UTF8";

    /**
     * 设置缓冲区大小4M
     **/
    private static final int BUFFER_SIZE = 1024 * 1024 * 4;

    /**
     * FTPClient对象
     **/


    private static FTPClient ftpClient = new FTPClient();

    /**
     * java编程中用于连接到FTP服务器
     *
     * @param hostname 主机名
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @return 是否连接成功
     * @throws IOException
     */
    public boolean connect(String hostname, int port, String username,
                           String password) throws IOException {
        ftpClient.connect(hostname, port);
        if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            if (ftpClient.login(username, password)) {
                return true;
            }
        }
        disconnect();
        return false;
    }

    /**
     * 断开与远程服务器的连接
     *
     * @throws IOException
     */
    public void disconnect() throws IOException {
        System.out.println("断开连接");
        if (ftpClient.isConnected()) {
            ftpClient.disconnect();
        }
    }

    /**
     * FTP 单个文件下载
     * @param ftpClient ftp对象
     * @param localPath 本地路径
     * @param localFileName 本地文件名
     * @param remotePath 远程路径
     * @param remoteFileName 远程文件名
     * @return
     */
    public static String FTPdownFile(FTPClient ftpClient,String localPath,String localFileName,String remotePath,String remoteFileName,int timeout){

        OutputStream os = null;
        try {
            ftpClient.setConnectTimeout(timeout);
            //ftpClient.setControlEncoding("utf-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(new String(remotePath.getBytes("UTF-8"),"ISO-8859-1"));

            boolean b = ftpClient.changeWorkingDirectory(remotePath);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("查询申请文件未找到 : " + remotePath);
                }
                return "000143";
            }
            /**判断本地文件夹是否存在*/
            if(!new File(localPath).isDirectory()){
                new File(localPath).mkdirs();
            }
            File localFile = new File(localPath + File.separator + localFileName);
            os = new FileOutputStream(localFile);
            b = ftpClient.retrieveFile(remoteFileName, os);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("下载文件失败 : " + localPath + File.separator + localFileName);
                }
                return "000142";
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("查询申请文件未找到 : " + localPath + File.separator + localFileName);
            }
            return "000143";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("下载文件失败 : " + localPath + File.separator + localFileName);
            }
            return "000142";

        }finally{
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "00000";
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public static void main(String[] args) throws IOException {
//        FtpUtils ftpUtils = new FtpUtils();
//        System.out.println(ftpUtils.connect("192.168.5.80",21,"root","root"));
//        FTPClient ftpClient = ftpUtils.getFtpClient();
//        ftpClient.setControlEncoding("gbk");
//       // FTPdownFile(ftpClient,"G:\\FtpTest","test.txt","/test","测试.txt",100);
//        ftpClient.changeWorkingDirectory("/test");
//        FTPFile[] ftps = ftpClient.listFiles();
//        File localFile = new File("G:\\FtpTest\\test.txt");
//        FileOutputStream os = new FileOutputStream(localFile);
//        System.out.println("下载："+ftpClient.retrieveFile(ftps[3].getName(), os));
//        System.out.println(ftps[3].getName());
        File file = new File("G:\\FtpTest");
        String[] filelist = file.list();
    }

    private static String changeEncoding(String ftpPath) {
        String directory = null;
        try {
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand(OPTS_UTF8, "ON"))) {
                localCharset = CHARSET_UTF8;
            }
            directory = new String(ftpPath.getBytes(localCharset), serverCharset);
        } catch (Exception e) {
            log.error("路径编码转换失败", e);
        }
        return directory;
    }

}
