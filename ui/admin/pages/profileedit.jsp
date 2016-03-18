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
    <input type="hidden" name="<%=Constants.W%>" value="<%=Constants.PROFILE_SETTING_PRM%>">
    <input type="hidden" name="<%=Constants.ACT%>" value="<%=Constants.ACT_CREATE_SAVE%>">
    <div class="form">
      <h2 class="title">Profile</h2>
      <label class="errormsg"></label>
      
      <fieldset>
        <div>
          <textarea rows="50" class="tiny" name="<%=Constants.COMPANY_PROFILE_PARAM %>"><%=null!=cp.get(Constants.COMPANY_PROFILE_PARAM)?Utilities.showStringValue(cp.get(Constants.COMPANY_PROFILE_PARAM).getValue()):""%></textarea>
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