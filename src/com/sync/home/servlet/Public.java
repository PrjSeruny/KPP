package com.sync.home.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.servlet.CoreServlet;
import com.sync.core.utils.Constants;
import com.sync.core.utils.Utilities;
import com.sync.home.utils.PublicConstants;
import com.sync.master.utils.MasterConstants;

public class Public extends CoreServlet
{
	/** Serialization ID. */
	private static final long serialVersionUID = 7946444851614790377L;
	
	/** Init method. this is called when tomcat is started. */
	public void init(){}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		this.doPost(req, res);
		return;
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{			
		String what = getServletConfig().getInitParameter(PublicConstants.W);
		System.out.println("GET WHAT ???? " + what);
		if(!Utilities.isEmpy(what) && what.equals(PublicConstants.PUBLIC_HOME_PRM))
		{this.doPublicHome(req, res);}
		else if(!Utilities.isEmpy(what) && what.equals(PublicConstants.PUBLIC_ABOUT_PRM))
		{this.doPublicAbout(req, res);}
		else if(!Utilities.isEmpy(what) && what.equals(PublicConstants.PUBLIC_NEWS_PRM))
		{this.doPublicNews(req, res);}
		else if(!Utilities.isEmpy(what) && what.equals(PublicConstants.PUBLIC_GALLERY_PRM))
		{this.doPublicGallery(req, res);}
		else if(!Utilities.isEmpy(what) && what.equals(PublicConstants.PUBLIC_CONTACT_PRM))
		{this.doPublicContact(req, res);}
		else
		{
			this.doPublicHome(req, res);
			//super.openURL(PublicConstants.PUBLIC_HOME_PAGE, req, res);
		}
		
		return;
	}
	
	public void doPublicHome(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("_________________ HOME PAGE _________________");
		super.openURL(PublicConstants.PUBLIC_HOME_PAGE, req, res);
    return;
	}
	
	public void doPublicAbout(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("_________________ ABOUT PAGE _________________");
		super.openURL(PublicConstants.PUBLIC_ABOUT_PAGE, req, res);
    return;
	}
	
	public void doPublicNews(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("_________________ NEWS PAGE _________________");
    super.openURL(PublicConstants.PUBLIC_NEWS_PAGE, req, res);
    return;
	}
	
	public void doPublicGallery(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("_________________ GALLERY PAGE _________________");
		super.openURL(PublicConstants.PUBLIC_GALLERY_PAGE, req, res);
    return;
	}
	
	public void doPublicContact(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("_________________ CONTACT PAGE _________________");
		super.openURL(PublicConstants.PUBLIC_CONTACT_PAGE, req, res);
    return;
	}
}
