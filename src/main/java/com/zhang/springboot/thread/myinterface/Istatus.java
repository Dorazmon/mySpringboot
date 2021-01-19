package com.zhang.springboot.thread.myinterface;

import com.zhang.springboot.thread.enums.StatusEnum;

import java.util.List;
import java.util.Set;

public interface Istatus {
  public StatusEnum getStatus();
  public void noInputOutPutMethod();
  public void noOutPutMethod(int input);
  public int noInputMethod();
  public int baseMethod(int input);
  public void noOutPutObjectMethod(Istatus istatus);
  public Istatus noInputObjectMethod();
  public Istatus ObjectMehtod();
  public List<Istatus> getListObject();
  //public void getListObject();
  public void getListObject(int input);
  //public List<Istatus> getListObject(int input);
  ///public Set<Istatus> getListObject();
  public Set<Istatus> getListObject(int input, String hello);
}