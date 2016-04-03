<%@page import="com.sync.report.beans.ResidentAnalysisDetailsBean"%>
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
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
     if(null!=msg)
     {
       genmsg = msg.getMessageBean(MessageBean.MSG_ERR);
       System.out.println(">>>>>>>>>>>>> genmsg= "+genmsg);
     }
   }
   String city = "", kec="", kel="";
%>
<fieldset class="wrapper">
  <form name="search" method="post" action="<%=Constants.ROOT_PATH%><%=ReportConstants.SVT_REPORT_PATH%>">
     <input type="hidden" name="<%=ReportConstants.W%>" value="<%=ReportConstants.REPORT_RESIDENTANALYSIS%>">
     <input type="hidden" name="<%=ReportConstants.ACT%>" value="<%=ReportConstants.ACT_SEARCH_QUERY%>">
    <div class="form">
      <h2 class="title">Analisa Penduduk</h2>
      <fieldset>
        <div><label>Tipe Pencarian</label></div>
        <div><label class="input"><input type="radio" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH%>" value="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_DETAILS%>" <%=(null==ubn) || (null!=ubn && ubn.getWhatToSearch().equals(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_DETAILS))?"checked":"checked"%> >Data Kependudukan</label></div>
        <!-- div><label class="input"><input type="radio" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH%>" value="<%=ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_RECAP%>">Rekapitulasi Data</label></div -->
        <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH):""%></span>
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
<%
    if(null!=ubn && null!=ubn.getCitys())
    {
     city = Utilities.join(ReportConstants.DELIMITER_SEMICOLON, ubn.getCitys());
    }
%>        
        <div>
          <label>Kota</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals1"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_CITY%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals1" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_CITY%>"><%=!Utilities.isEmpy(city)?city:""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_CITY):""%></span>
        </div>
      </fieldset>
<%
    if(null!=ubn && null!=ubn.getKelVal())
    {
     kel = Utilities.join(ReportConstants.DELIMITER_SEMICOLON, ubn.getKelVal());
    }
%>        
        
      <fieldset>
         <div>
          <label>Kelurahan</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals2"
          param="width=600;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_KEL%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals2" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_KEL%>"><%=!Utilities.isEmpy(kel)?kel:""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_KEL):""%></span>
        </div>
<%
    if(null!=ubn && null!=ubn.getKecVal())
    {
     kec = Utilities.join(ReportConstants.DELIMITER_SEMICOLON, ubn.getKecVal());
    }
%>        
        <div>
          <label>Kecamatan</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVals3"
          param="width=600;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION_KEC%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Cari</a>
         <textarea id="userIDVals3" name="<%=ReportConstants.FORM_RESIDENTANALYSIS_KEC%>"><%=!Utilities.isEmpy(kec)?kec:""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(ReportConstants.FORM_RESIDENTANALYSIS_KEC):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
             <label>Group Berdasarkan:</label>
            <select name="<%=ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY%>">
            <option value="<%=ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_CITY%>"<%=null!=ubn && ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_CITY)?"selected":""%>>Kota</option>
            <option value="<%=ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEC%>"<%=null!=ubn && ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEC)?"selected":""%>>Kecamatan</option>
            <option value="<%=ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEL%>"<%=null!=ubn && ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEL)?"selected":""%>>Kelurahan</option>
            </select>
        </div>
      </fieldset>
      <fieldset>
        <div> 
          <input type="submit" value="Cari">
        </div>
      </fieldset>
    </div>
  </form>
  <fieldset>
  <div class="form" style="clear:left;width: 100%;margin: auto;display: -webkit-box;min-height: 500px;"> 
  <div class="list-con" style="text-align: center;width: 100%;">
  <%
    ResidentAnalysisDetailsBean[] list = null;
   if(null!=ubn)
   {
     list = ubn.getDetails();     
   }
%>  
  <table border="0" class="list-tb" style="width: 100%;">
                    <tr>
                        <th>NIK</th>
                        <th>No.KK</th>
                        <th>Nama</th>
                        <th>Jenis Kelamin</th>
                        <th>Tgl Lahir</th>
                        <th>Alamat</th>
                        <th>Kelurahan</th>
                        <th>Kecamatan</th>
                        <th>Kota</th>
                        <th>Agama</th>
                        <th>Email</th>
                        <th>Tlp</th>
                        <th>No.HP</th>
                    </tr>
<%
   String id = "";
   boolean groupBy = false, showCount=false;;
   int count=0;
   String signCol="";
   if(null!=list && list.length>0)
   {
     for(int i=0; i<list.length; i++)
     {
       if(i%2==0) signCol="white";
       else signCol="#e0fad2";
       
       if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_CITY))
       {
         if(!id.equals(list[i].getCity()) && null!=list[i])
         {
           id = list[i].getCity();
           groupBy = true;
         }
       }
       else if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEC))
       {
         if(!id.equals(list[i].getKecamatan()) && null!=list[i])
         {
           id = list[i].getKecamatan();
           groupBy = true;
         }
       }
       else if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEL))
       {
         if(!id.equals(list[i].getKelurahan()) && null!=list[i])
         {
           id = list[i].getKelurahan();
           groupBy = true;
         }
       }
       
       if(groupBy)
       {
%>
                     <tr>
                        <td colspan="13" align="left"><font color="blue"><b><%=id%></b></font></td>
                     </tr>
<%         
       }
%>
                      <tr bgcolor="<%=signCol%>">
                        <td valign="top"><%=list[i].getNIK()%></a></td>
                        <td valign="top"><%=list[i].getKKNo()%></td>
                        <td valign="top" align="left"><%=list[i].getName()%></td>
                        <td valign="top"><%=list[i].getSexVal()%></td>
                        <td valign="top"><%=Utilities.dateToString(list[i].getBirthDate(), Constants.DATE_HTML_SHORT_PATTERN)%></td>
                        <td valign="top" align="left"><%=list[i].getAddress()%></td>
                        <td valign="top" align="left"><%=list[i].getKelurahan()%></td>
                        <td valign="top" align="left"><%=list[i].getKecamatan()%></td>
                        <td valign="top" align="left"><%=list[i].getCity()%></td>
                        <td valign="top"><%=list[i].getReligion()%></td>
                        <td valign="top"><%=!Utilities.isEmpy(list[i].getEmail())?list[i].getEmail():""%></td>
                        <td valign="top"><%=!Utilities.isEmpy(list[i].getPhone())?list[i].getPhone():""%></td>
                        <td valign="top"><%=!Utilities.isEmpy(list[i].getMobileNo())?list[i].getMobileNo():""%></td>
                      </tr>
<%       
          groupBy = false;
          showCount = false;
          count++;
          if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_CITY))
          {
            if(
                (i<list.length-1 && !id.equals(list[i+1].getCity())) ||
                (i==list.length-1)
              )
            { 
              showCount = true;
            }
          }
          else if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEC))
          {
            if(
                (i<list.length-1 && !id.equals(list[i+1].getKecamatan())) ||
                (i==list.length-1)
              )
            { 
              showCount = true;
            }
          }
          else if(ubn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEL))
          {
            if(
                (i<list.length-1 && !id.equals(list[i+1].getKelurahan())) ||
                (i==list.length-1)
              )
            { 
              showCount = true;
            }
          }
          
          if(showCount)
          {
%>
            <tr bgcolor="#def2f4">
              <td colspan="13" align="left"><font color="black"><b>Total Penduduk <%=id%>: <%=count%></b></font></td>
            </tr>
<%            
             count = 0;
          }
	   }
	 }
	 else
	 {
%>
                     <tr>
                       <td valign="top" align="center" colspan="13">Data yang dicari tidak ditemukan!</td>
                     </tr>
<%
     }
%>                     
              </table>
              </div>
              </div>
  </fieldset>
</fieldset>