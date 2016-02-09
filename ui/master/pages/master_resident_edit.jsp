<%@page import="com.sync.master.beans.MasterResidentBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(MasterConstants.ACT);
   MasterResidentBean ubn = (MasterResidentBean)request.getAttribute(MasterConstants.MASTERRESIDENT_INFO);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
   }
   
%>
<fieldset class="wrapper">
  <form name="create" method="post" action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
     <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTER_RESIDENT%>">
     <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Tambah Penduduk</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(MasterConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div >
          <label>NIK</label>
<%
   if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE_SAVE)) type = "hidden";
   else type="text";
%>            
               <input type="<%=type%>" name="<%=MasterConstants.FORM_MASTERRESIDENT_NIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNIK()):""%>">
<%
   if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE_SAVE))
   {
     out.println(ubn.getNIK());
   }
%>               
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_NIK):""%></span>
        </div>
        <div >
          <label>No.KK</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_KK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKKNo()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_KK):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Nama</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_NAME):""%></span>
        </div>
        <div >
          <label>Kota Lahir</label><a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVal;#userNameVal"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1&<%=MasterConstants.FORM_MASTERREGION_REGIONONLY%>=true">Cari</a>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_BIRTHCITY %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getCity()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_BIRTHCITY):""%></span>
        </div>
        <div >
          <label>Tanggal Lahir</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_BIRTHDATE %>" value="<%=null!=ubn?Utilities.showStringValue(Utilities.dateToString(ubn.getBirthDate(), MasterConstants.DATE_HTML_SHORT_PATTERN)):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_BIRTHDATE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Jenis Kelamin</label>
          <select name="<%=MasterConstants.FORM_MASTERRESIDENT_SEX%>">
             <option value="<%=MasterConstants.SEX_M%>"<%=null!=ubn && ubn.getSex()==MasterConstants.SEX_M?"selected":""%>>Laki-Laki</option>
             <option value="<%=MasterConstants.SEX_F%>"<%=null!=ubn && ubn.getSex()==MasterConstants.SEX_F?"selected":""%>>Perempuan</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_SEX):""%></span>
        </div>
        <div >
          <label>Agama</label>
          <select name="<%=MasterConstants.FORM_MASTERRESIDENT_RELIGION%>">
             <option value="<%=MasterConstants.RELIGION_ISLAM%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_ISLAM)?"selected":""%>>Islam</option>
             <option value="<%=MasterConstants.RELIGION_CHRISTIAN%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_CHRISTIAN)?"selected":""%>>Kristen</option>
             <option value="<%=MasterConstants.RELIGION_KATOLIK%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_KATOLIK)?"selected":""%>>Katolik</option>
             <option value="<%=MasterConstants.RELIGION_HINDU%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_HINDU)?"selected":""%>>Hindu</option>
             <option value="<%=MasterConstants.RELIGION_BUDHA%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_BUDHA)?"selected":""%>>Budha</option>
             <option value="<%=MasterConstants.RELIGION_OTHERS%>" <%=null!=ubn && ubn.getReligion().equals(MasterConstants.RELIGION_OTHERS)?"selected":""%>>Lainnya</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_RELIGION):""%></span>
        </div>
        <div >
          <label>Status Pernikahan</label>
          <select name="<%=MasterConstants.FORM_MASTERRESIDENT_MARITALSTATUS%>">
             <option value="<%=MasterConstants.MARITALSTAT_SINGLE%>"<%=null!=ubn && ubn.getMaritalStatus().equals(MasterConstants.MARITALSTAT_SINGLE)?"selected":""%>>Lajang</option>
             <option value="<%=MasterConstants.MARITALSTAT_MARRIED%>"<%=null!=ubn && ubn.getMaritalStatus().equals(MasterConstants.MARITALSTAT_MARRIED)?"selected":""%>>Menikah</option>
             <option value="<%=MasterConstants.MARITALSTAT_WIDOW%>"<%=null!=ubn && ubn.getMaritalStatus().equals(MasterConstants.MARITALSTAT_WIDOW)?"selected":""%>>Duda/Janda</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_MARITALSTATUS):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label>Pekerjaan</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_WORK %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getWork()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_WORK):""%></span>
        </div>
        <div>
          <label>Kewarganegaraan</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_NATIONALITY %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNationality()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_NATIONALITY):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Alamat</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_ADDRESS %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getAddress()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_ADDRESS):""%></span>
        </div>
        <div >
          <label>Kota</label><a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVal;#userNameVal"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1&<%=MasterConstants.FORM_MASTERREGION_REGIONONLY%>=false">Cari</a>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_CITY %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getCity()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_CITY):""%></span>
        </div>
        <div >
          <label>Propinsi</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_REGION %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRegion()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_REGION):""%></span>
        </div>
        <div >
          <label>Kode Pos</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_POSTALCODE %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getPostalCode()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_POSTALCODE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Kecamatan</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_KECAMATAN %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKecamatan()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_KECAMATAN):""%></span>
        </div>
        <div >
          <label>Kelurahan</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_KELURAHAN %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKelurahan()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_KELURAHAN):""%></span>
        </div>
        <div >
          <label>RT</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_RT %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRT()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_RT):""%></span>
        </div>
        <div >
          <label>RW</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERRESIDENT_RW %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRW()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_RW):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div class="full">
          <label>Note</label>
          <textarea rows="5" cols="50" name="<%=MasterConstants.FORM_MASTERRESIDENT_NOTE%>"><%=null!=ubn?Utilities.showStringValue(ubn.getNote()):""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERRESIDENT_NOTE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <input type="submit" value="Simpan">
          <%
      if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE))
      {
      %>     
           <input type="reset" value="Reset" class="negate">
      <%
      }
      else
      {
      %>
           <input type="submit" name="<%=MasterConstants.BTN_CANCEL%>" value="Batal" class="negate">
      <%  
      }
      %>
        </div>
      </fieldset>
    </div>
  </form>
</fieldset>