<%@page import="com.sync.master.beans.MasterResidentBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<fieldset class="wrapper">
  <div class="form" style="clear:left">
    <h2 class="title">Daftar Region</h2>
    <form method="post"  class="ajax-form" dst="residentlist" id="residentlist" 
    action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>">
      <jsp:include page="<%=MasterConstants.MASTER_REGION_LIST%>" flush="true"/>
    </form>
  </div>
</fieldset>
