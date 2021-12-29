package com.crm.genericutility;

import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Organizations;

import pomrepositery.CreateNewOrganization;
import pomrepositery.OrganizationInfo;

public class CreateOrganization  extends BaseClass{
	
	@Test
	public void createOrgTest() throws Throwable {
		
		int randomInt = jLib.getRanDomNumber();
		/*test script Data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;

      /*step 2 : navigate to organization*/
      Home homePage = new Home(driver);
      homePage.getOrganizationLnk().click();
      
      /*step 3 : navigate to "create new organization"page by click on "+" image */
      Organizations orgPage = new Organizations(driver);
      orgPage.getCreateOrgImg().click();
      
      /*step 4 : create organization*/
      CreateNewOrganization cno = new CreateNewOrganization(driver);
      cno.createOrg(orgName);
      
     /*step 5 : verify the successful msg with org name*/
      OrganizationInfo orginfoPage = new OrganizationInfo(driver);
      String  actSuccesfullMg =  orginfoPage.getSuccesfullMsg().getText();
      if(actSuccesfullMg.contains(orgName)) {
      	System.out.println(orgName + "==>created successfully");
      }else {
      	System.out.println(orgName + "==> not created successfully");

      }
	}
	
	
	@Test
	public void createOrgWithIndutriesTest() throws Throwable {
		/*test script Data*/
		int randomInt = jLib.getRanDomNumber();
		String orgName = eLib.getDataFromExcel("Sheet1", 4, 2) + randomInt;
		String industriesType = eLib.getDataFromExcel("Sheet1", 4, 3);
		 /*step 2 : navigate to organization*/
      Home homePage = new Home(driver);
      homePage.getOrganizationLnk().click();
      
      /*step 3 : navigate to "create new organization"page by click on "+" image */
      Organizations orgPage = new Organizations(driver);
      orgPage.getCreateOrgImg().click();
      
      /*step 4 : create organization*/
      CreateNewOrganization cno = new CreateNewOrganization(driver);
      cno.createOrg(orgName, industriesType);
      
      /*verify orgname & industry */
      OrganizationInfo orginfoPage = new OrganizationInfo(driver);
      String  actSuccesfullMg =  orginfoPage.getSuccesfullMsg().getText();
      if(actSuccesfullMg.contains(orgName)) {
      	System.out.println(orgName + "==>created successfully");
      }else {
      	System.out.println(orgName + "==> not created successfully");

      }
      
      String actIndustryType = orginfoPage.getIndutryTypeInfo().getText();
      if(actIndustryType.equals(industriesType)) {
      	System.out.println(industriesType + "==>industry is verified successfully");
      }else {
      	System.out.println(industriesType + "==>industry is not verified successfully");

      }
	}
	
	@Test
	public void createOrgWithRatingTest() throws Throwable {
		/*test script Data*/
		int randomInt = jLib.getRanDomNumber();
		String orgName = eLib.getDataFromExcel("Sheet1", 7, 2) + randomInt;
		String rating = eLib.getDataFromExcel("Sheet1", 7, 3);
		   /*step 2 : navigate to organization*/
      Home homePage = new Home(driver);
      homePage.getOrganizationLnk().click();
      
      /*step 3 : navigate to "create new organization"page by click on "+" image */
      Organizations orgPage = new Organizations(driver);
      orgPage.getCreateOrgImg().click();
      
      /*step 4 : create organization*/
      CreateNewOrganization cno = new CreateNewOrganization(driver);
      cno.createOrg(orgName, rating, true);
      
      /*verify orgname & industry */
      OrganizationInfo orginfoPage = new OrganizationInfo(driver);
      String  actSuccesfullMg =  orginfoPage.getSuccesfullMsg().getText();
      if(actSuccesfullMg.contains(orgName)) {
      	System.out.println(orgName + "==>created successfully");
      }else {
      	System.out.println(orgName + "==> not created successfully");

      }       
      String actRatingType = orginfoPage.getRatingTypeInfo().getText();
      
      if(actRatingType.equals(rating)) {
      	System.out.println(rating + "==>industry is verified successfully");
      }else {
      	System.out.println(rating + "==>industry is not verified successfully");

      }
	}
}
	

