<%@page import="com.sync.report.utils.ReportConstants"%>
<%@page import="com.sync.report.beans.ResidentAnalysisBean"%>
<%@page import="com.sync.master.utils.MasterConstants"%>
<%@page import="com.sync.trans.beans.DeathLetterBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(ReportConstants.ACT);
   ResidentAnalysisBean ubn = (ResidentAnalysisBean)request.getAttribute(ReportConstants.RESIDENTANALYSIS_LIST);
   MessageBean msg = null;
   String genmsg ="";
   
%>
<fieldset class="wrapper">
  <form name="search" method="post" action="<%=Constants.ROOT_PATH%><%=ReportConstants.SVT_REPORT_PATH%>">
     <input type="hidden" name="<%=ReportConstants.W%>" value="<%=ReportConstants.REPORT_RESIDENTANALYSIS%>">
     <input type="hidden" name="<%=ReportConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Analisa Penduduk</h2>
      <fieldset>
        <div><label class="input"><input type="radio" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_DETAILS%>">Data Kependudukan</label></div>
        <div><label class="input"><input type="radio" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_RECAP%>">Rekapitulasi Data</label></div>
      </fieldset>
      <fieldset>
        <div>
          <label>NIK</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_NIK%>"></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_NIK):""%></span>
        </div>
        <div>
          <label>Kota</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals1"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_CITY%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals1" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_CITY%>"></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_CITY):""%></span>
        </div>
      </fieldset>
      <fieldset>
         <div>
          <label>Kelurahan</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals2"
          param="width=600;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_KEL%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals2" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_KEL%>"></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_KEL):""%></span>
        </div>
        <div>
          <label>Kecamatan</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals3"
          param="width=600;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_KEC%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals3" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_KEC%>"></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_KEC):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <input type="submit" value="Cari">
        </div>
      </fieldset>
    </div>
  </form>
</fieldset>