package com.cucumbercraft.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class GetDriver {
private static GetDriver oneTimeData;
private static WebDriver driver=null;
private static String refOIC=""; 
private static Map<String,String> getLoginLocators=new HashMap<String,String>();
private static Map<String,String> getUnrepLocators=new HashMap<String,String>();
private static Map<String,String> getCompensatorLocators=new HashMap<String,String>();
private static Map<String,String> getProUserLocators=new HashMap<String,String>();
private static Map<String,String> getClaimantActionsLocators=new HashMap<String,String>();
private static Map<String,String> getMIBproLocators=new HashMap<String,String>();
private static Map<String,String> getCSRLocators=new HashMap<String,String>();
private static Map<String,String> getSuperUserLocators=new HashMap<String,String>();
private static Map<String,String> getTPALocators=new HashMap<String,String>();
private static Map<String,String> getDMELocators=new HashMap<String,String>();
private static Map<String,String> getULocators=new HashMap<String,String>();
private static Map<String,String> getStatusLocators=new HashMap<String,String>();
private static Map<String,String> getCompStatusLocators=new HashMap<String,String>();
private static Map<String,String> getProUserStatusLocators=new HashMap<String,String>();
private static boolean getCompensatorStatus;
private static boolean getMultiVRNStatus;
private static boolean getNVCStatus;
private static boolean getMedrep;
public static GetDriver getInstance() {
	if(Objects.isNull(oneTimeData))
		oneTimeData = new GetDriver();	
	return oneTimeData;
}

public static GetDriver getOneTimeData(){
	return oneTimeData;
}
public static void setOneTimeData(GetDriver oneTimeData) {
	GetDriver.oneTimeData=oneTimeData;
}


public WebDriver getDriver(){
	return driver;
}
public void setDriver(WebDriver driver) {
	GetDriver.driver=driver;
}

public boolean getCompensatorStatus(){
	return getCompensatorStatus;
}
public void setCompensatorStatus(boolean getCompensatorStatus) {
	GetDriver.getCompensatorStatus=getCompensatorStatus;
}

public boolean getMultiVRNStatus(){
	return getMultiVRNStatus;
}
public void setMultiVRNStatus(boolean getMultiVRNStatus) {
	GetDriver.getMultiVRNStatus=getMultiVRNStatus;
}

public boolean getNVCStatus(){
	return getNVCStatus;
}
public void setNVCstatus(boolean getNVCStatus) {
	GetDriver.getNVCStatus=getNVCStatus;
}

public boolean getMedrep(){
	return getMedrep;
}
public void setMedrep(boolean getMedrep) {
	GetDriver.getMedrep=getMedrep;
}


public Map<String,String> getLoginLocators(){
	return getLoginLocators;
}
public void setLoginLocators(Map<String,String> locatorLoginMap) {
	GetDriver.getLoginLocators=locatorLoginMap;
}

public Map<String,String> getStatusLocators(){
	return getStatusLocators;
}
public void setStatusLocators(Map<String,String> locatorStatusMap) {
	GetDriver.getStatusLocators=locatorStatusMap;
}

public Map<String,String> getCompStatusLocators(){
	return getCompStatusLocators;
}
public void setCompStatusLocators(Map<String,String> locatorCompStatusMap) {
	GetDriver.getCompStatusLocators=locatorCompStatusMap;
}


public Map<String,String> getProUserStatusLocators(){
	return getProUserStatusLocators;
}
public void setProUserStatusLocators(Map<String,String> locatorProUserStatusMap) {
	GetDriver.getProUserStatusLocators=locatorProUserStatusMap;
}

public Map<String,String> getUnrepLocators(){
	return getUnrepLocators;
}
public void setUnrepLocators(Map<String,String> locatorUnrepMap) {
	GetDriver.getUnrepLocators=locatorUnrepMap;
}

public Map<String,String> getCompensatorLocators(){
	return getCompensatorLocators;
}
public void setCompensatorLocators(Map<String,String> locatorCompensator) {
	GetDriver.getCompensatorLocators=locatorCompensator;
}
public Map<String,String> getProUserLocators(){
	return getProUserLocators;
}
public void setProUserLocators(Map<String,String> locatorProUser) {
	GetDriver.getProUserLocators=locatorProUser;
}

public Map<String,String> getClaimantActionsLocators(){
	return getClaimantActionsLocators;
}
public void setClaimantActionsLocators(Map<String,String> locatorClaimantActions) {
	GetDriver.getClaimantActionsLocators=locatorClaimantActions;
}

public Map<String,String> getMIBproLocators(){
	return getMIBproLocators;
}
public void setMIBproLocators(Map<String,String> locatorMIBpro) {
	GetDriver.getMIBproLocators=locatorMIBpro;
}


public Map<String,String> getCSRLocators(){
	return getCSRLocators;
}
public void setCSRLocators(Map<String,String> locatorCSR) {
	GetDriver.getCSRLocators=locatorCSR;
}

public Map<String,String> getSuperUserLocators(){
	return getSuperUserLocators;
}
public void setSuperUserLocators(Map<String,String> locatorSuperUser) {
	GetDriver.getSuperUserLocators=locatorSuperUser;
}
public Map<String,String> getDMELocators(){
	return getDMELocators;
}
public void setDMELocators(Map<String,String> locatorDME) {
	GetDriver.getDMELocators=locatorDME;
}


public Map<String,String> getTPALocators(){
	return getTPALocators;
}
public void setTPALocators(Map<String,String> locatorTPA) {
	GetDriver.getTPALocators=locatorTPA;
}

public Map<String,String> getULocators(){
	return getULocators;
}
public void setULocators(Map<String,String> locatorUser) {
	GetDriver.getULocators=locatorUser;
}
public String getOICref(){
	return refOIC;
}
public void setOICref(String refOIC) {
	GetDriver.refOIC=refOIC;
}

}
