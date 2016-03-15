<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<fieldset class="wrapper" id="gedit">
  <jsp:include page="<%=Constants.GALLERY_EDIT_PG%>" flush="true"/>
</fieldset>

<fieldset class="wrapper" id="glist">
  <jsp:include page="<%=Constants.GALLERY_LIST_PG%>" flush="true"/>
</fieldset>