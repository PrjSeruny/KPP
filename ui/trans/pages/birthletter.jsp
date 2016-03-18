<%@page import="com.sync.trans.utils.TransConstants"%>
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
    <h2 class="title">Daftar Data Kelahiran</h2>
    <form method="post"  class="ajax-form" dst="birthlist" id="birthlist" 
    action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_BIRTHLETTER%>">
      <jsp:include page="<%=TransConstants.PAGE_BIRTHLETTER_LIST%>" flush="true"/>
    </form>
  </div>
</fieldset>
