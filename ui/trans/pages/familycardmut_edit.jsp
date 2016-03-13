<%@page import="com.sync.master.utils.MasterConstants"%>
<%@page import="com.sync.trans.beans.FamilyCardMutationBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.trans.utils.TransConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(TransConstants.ACT);
   FamilyCardMutationBean ubn = (FamilyCardMutationBean)request.getAttribute(TransConstants.FAMILYCARDMUT_INFO);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
   }
   
%>
<fieldset class="wrapper">
  <form name="create" method="post" action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>">
     <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_FAMILYCARDMUT%>">
     <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Mutasi KK</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(TransConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div >
          <label>NIK</label>
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE)) type = "hidden";
   else type="text";
%>            
               <input type="<%=type%>" name="<%=TransConstants.FORM_FAMILYCARDMUT_NIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNIK()):""%>">
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE))
   {
     out.println(ubn.getNIK());
   }
%>               
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_NIK):""%></span>
        </div>
        <div >
          <label>Tgl Mulai Berlaku KK Baru</label>
          <input type="<%=type%>" name="<%=TransConstants.FORM_FAMILYCARDMUT_STARTDATE%>" value="<%=null!=ubn?Utilities.showStringValue(Utilities.dateToString(ubn.getStartDate(), MasterConstants.DATE_HTML_SHORT_PATTERN)):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_STARTDATE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label>Nama</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_NAME):""%></span>
        </div>
        <div>
          <label>No.KK Lama</label>
          <input type="<%=type%>" name="<%=TransConstants.FORM_FAMILYCARDMUT_OLDKK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getOldKK()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_OLDKK):""%></span>
        </div>
        <div >
          <label>No.KK Baru</label>
          <input type="<%=type%>" name="<%=TransConstants.FORM_FAMILYCARDMUT_NEWKK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNewKK()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_NEWKK):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Jenis Kelamin</label>
          <select name="<%=TransConstants.FORM_FAMILYCARDMUT_SEX%>">
             <option value="<%=TransConstants.SEX_M%>"<%=null!=ubn && ubn.getSex()==TransConstants.SEX_M?"selected":""%>>Laki-Laki</option>
             <option value="<%=TransConstants.SEX_F%>"<%=null!=ubn && ubn.getSex()==TransConstants.SEX_F?"selected":""%>>Perempuan</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_SEX):""%></span>
        </div>
        <div >
          <label>Agama</label>
          <select name="<%=TransConstants.FORM_FAMILYCARDMUT_RELIGION%>">
             <option value="<%=TransConstants.RELIGION_ISLAM%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_ISLAM)?"selected":""%>>Islam</option>
             <option value="<%=TransConstants.RELIGION_CHRISTIAN%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_CHRISTIAN)?"selected":""%>>Kristen</option>
             <option value="<%=TransConstants.RELIGION_KATOLIK%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_KATOLIK)?"selected":""%>>Katolik</option>
             <option value="<%=TransConstants.RELIGION_HINDU%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_HINDU)?"selected":""%>>Hindu</option>
             <option value="<%=TransConstants.RELIGION_BUDHA%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_BUDHA)?"selected":""%>>Budha</option>
             <option value="<%=TransConstants.RELIGION_OTHERS%>" <%=null!=ubn && ubn.getReligion().equals(TransConstants.RELIGION_OTHERS)?"selected":""%>>Lainnya</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_RELIGION):""%></span>
        </div>
        <div>
          <label>Status Pernikahan</label>
          <select name="<%=TransConstants.FORM_FAMILYCARDMUT_MARITALSTATUS%>">
             <option value="<%=TransConstants.MARITALSTAT_SINGLE%>"<%=null!=ubn && ubn.getMaritalStatus().equals(TransConstants.MARITALSTAT_SINGLE)?"selected":""%>>Lajang</option>
             <option value="<%=TransConstants.MARITALSTAT_MARRIED%>"<%=null!=ubn && ubn.getMaritalStatus().equals(TransConstants.MARITALSTAT_MARRIED)?"selected":""%>>Menikah</option>
             <option value="<%=TransConstants.MARITALSTAT_WIDOW%>"<%=null!=ubn && ubn.getMaritalStatus().equals(TransConstants.MARITALSTAT_WIDOW)?"selected":""%>>Duda/Janda</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_MARITALSTATUS):""%></span>
        </div>
        <div>
          <label>Status Hub Dalam Keluarga</label>
          <select name="<%=TransConstants.FORM_FAMILYCARDMUT_FAMILYPOS%>">
             <option value="<%=TransConstants.FAMILY_POS_CHILD%>"<%=null!=ubn && ubn.getFamilyPosVal().equals(TransConstants.FAMILY_POS_CHILD)?"selected":""%>>Anak</option>
             <option value="<%=TransConstants.FAMILY_POS_MOTHER%>"<%=null!=ubn && ubn.getFamilyPosVal().equals(TransConstants.FAMILY_POS_MOTHER)?"selected":""%>>Istri</option>
             <option value="<%=TransConstants.FAMILY_POS_FATHER%>"<%=null!=ubn && ubn.getFamilyPosVal().equals(TransConstants.FAMILY_POS_FATHER)?"selected":""%>>Kepala Keluarga</option>
          </select>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_FAMILYPOS):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label>Kewarganegaraan</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_NATIONALITY%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNationality()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_NATIONALITY):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Alamat</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_ADDRESS %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getAddress()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_ADDRESS):""%></span>
        </div>
        <div >
          <label>Kota</label><a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVal;#userNameVal"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1&<%=MasterConstants.FORM_MASTERREGION_REGIONONLY%>=false&<%=TransConstants.FORM_FIELD1%>=create.<%=TransConstants.FORM_FAMILYCARDMUT_REGION%>&<%=TransConstants.FORM_FIELD2%>=create.<%=TransConstants.FORM_FAMILYCARDMUT_CITY%>&<%=TransConstants.FORM_FIELD3%>=create.<%=TransConstants.FORM_FAMILYCARDMUT_KECAMATAN%>&<%=TransConstants.FORM_FIELD4%>=create.<%=TransConstants.FORM_FAMILYCARDMUT_KELURAHAN%>">Cari</a>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_CITY %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getCity()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_CITY):""%></span>
        </div>
        <div >
          <label>Propinsi</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_REGION %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRegion()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_REGION):""%></span>
        </div>
        <div >
          <label>Kode Pos</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_POSTALCODE %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getPostalCode()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_POSTALCODE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div >
          <label>Kecamatan</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_KECAMATAN %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKecamatan()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_KECAMATAN):""%></span>
        </div>
        <div >
          <label>Kelurahan</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_KELURAHAN %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKelurahan()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_KELURAHAN):""%></span>
        </div>
        <div >
          <label>RT</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_RT %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRT()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_RT):""%></span>
        </div>
        <div >
          <label>RW</label>
          <input type="text" name="<%=TransConstants.FORM_FAMILYCARDMUT_RW %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getRW()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_RW):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div class="full">
          <label>Note</label>
          <textarea rows="5" cols="50" name="<%=TransConstants.FORM_FAMILYCARDMUT_NOTE%>"><%=null!=ubn?Utilities.showStringValue(ubn.getNote()):""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_FAMILYCARDMUT_NOTE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <input type="submit" value="Simpan">
          <%
      if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_CREATE))
      {
      %>     
           <input type="reset" value="Reset" class="negate">
      <%
      }
      else
      {
      %>
           <input type="submit" name="<%=TransConstants.BTN_CANCEL%>" value="Batal" class="negate">
      <%  
      }
      %>
        </div>
      </fieldset>
    </div>
  </form>
</fieldset>