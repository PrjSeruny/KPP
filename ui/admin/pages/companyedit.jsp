<%@page import="com.sync.core.pool.CompanyPool"%>
<%@page import="com.sync.core.utils.Utilities"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%

CompanyPool cp = CompanyPool.getInstance();

%>
<fieldset class="wrapper">
  <form method="post" action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>">
    <input type="hidden" name="<%=Constants.W%>" value="<%=Constants.COMPANY_SETTING_PRM%>">
    <input type="hidden" name="<%=Constants.ACT%>" value="<%=Constants.ACT_CREATE_SAVE%>">
    <div class="form">
      <h2 class="title">Contact Setting</h2>
      <label class="errormsg"></label>
      
      <fieldset>
        <div>
          <label>Alamat Kantor</label>
          <input type="text" name="<%=Constants.COMPANY_ADDRESS_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_ADDRESS_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_ADDRESS_PARAM).getValue()):""%>">
        </div>
        <div>
          <label>Alamat Email</label>
          <input type="text" name="<%=Constants.COMPANY_EMAIL_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_EMAIL_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_EMAIL_PARAM).getValue()):""%>">
        </div>
      </fieldset>
      
      <fieldset>
        <div>
          <label>Nomor Telepon</label>
          <input type="text" name="<%=Constants.COMPANY_PHONE_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_PHONE_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_PHONE_PARAM).getValue()):""%>">
        </div>
        <div>
          <label>Nomor Fax</label>
          <input type="text" name="<%=Constants.COMPANY_FAX_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_FAX_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_FAX_PARAM).getValue()):""%>">
        </div>
      </fieldset>
      
      <fieldset>
        <div>
          <label>Koordinat Latitude</label>
          <input type="text" name="<%=Constants.COMPANY_LAT_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_LAT_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_LAT_PARAM).getValue()):""%>">
        </div>
        <div>
          <label>Koordinat Longtitude</label>
          <input type="text" name="<%=Constants.COMPANY_LONG_PARAM %>" 
            value="<%=null!=cp.get(Constants.COMPANY_LONG_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_LONG_PARAM).getValue()):""%>">
        </div>
      </fieldset>
      
      <fieldset>
        <div>
          <input type="submit" value="Simpan">
        </div>
      </fieldset>
    </div>
  </form>
  </fieldset>