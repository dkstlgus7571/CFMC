package data.dto;

import java.time.LocalDate;

public class OpenClass {
   public int ocCode;
   public String oc_cCode; 
   public String oc_tCode; 
   public String oc_ctCode;   
   public LocalDate oc_acceptStart; 
   public LocalDate oc_acceptEnd; 
   public LocalDate oc_classStart;
   public LocalDate oc_classEnd;   
   public int oc_appliNum;
   public String oc_day;
   public String oc_epi;
   
   //classInfo
   public String c_code;
   public String c_group;
   public String c_name;
   public int c_personnel; 
   public String c_intro;
   public String c_material;
   
   //centerInfo
   public String ct_code; 
   public String ct_name; 
   public String ct_facName; 
   public String ct_facKind; 
   public String ct_address; 
   public String ct_tel;  
   public String ct_Ava;
   
   //epiinfo
   public String ep_epi;
   public String ep_useStart;
   public String ep_useEnd;
   
   //tutorinfo
   
   public String t_code; 
   public String t_name;
   @Override
   public String toString() {
      
      return "OpenClass [ocCode=" + ocCode + ", oc_cCode=" + oc_cCode + ", oc_tCode=" + oc_tCode + ", oc_ctCode="
            + oc_ctCode + ", oc_acceptStart=" + oc_acceptStart + ", oc_acceptEnd=" + oc_acceptEnd
            + ", oc_classStart=" + oc_classStart + ", oc_classEnd=" + oc_classEnd + ", oc_appliNum=" + oc_appliNum
            + ", oc_day=" + oc_day + ", oc_epi=" + oc_epi + ", c_code=" + c_code + ", c_group=" + c_group
            + ", c_name=" + c_name + ", c_personnel=" + c_personnel + ", c_intro=" + c_intro + ", c_material="
            + c_material + ", ct_code=" + ct_code + ", ct_name=" + ct_name + ", ct_facName=" + ct_facName
            + ", ct_facKind=" + ct_facKind + ", ct_address=" + ct_address + ", ct_tel=" + ct_tel + ", ct_Ava="
            + ct_Ava + ", ep_epi=" + ep_epi + ", ep_useStart=" + ep_useStart + ", ep_useEnd=" + ep_useEnd
            + ", t_code=" + t_code + ", t_name=" + t_name + "]";
   }
   public int getOcCode() {
      return ocCode;
   }
   public void setOcCode(int ocCode) {
      this.ocCode = ocCode;
   }
   public String getOc_cCode() {
      return oc_cCode;
   }
   public void setOc_cCode(String oc_cCode) {
      this.oc_cCode = oc_cCode;
   }
   public String getOc_tCode() {
      return oc_tCode;
   }
   public void setOc_tCode(String oc_tCode) {
      this.oc_tCode = oc_tCode;
   }
   public String getOc_ctCode() {
      return oc_ctCode;
   }
   public void setOc_ctCode(String oc_ctCode) {
      this.oc_ctCode = oc_ctCode;
   }
   public LocalDate getOc_acceptStart() {
      return oc_acceptStart;
   }
   public void setOc_acceptStart(LocalDate oc_acceptStart) {
      this.oc_acceptStart = oc_acceptStart;
   }
   public LocalDate getOc_acceptEnd() {
      return oc_acceptEnd;
   }
   public void setOc_acceptEnd(LocalDate oc_acceptEnd) {
      this.oc_acceptEnd = oc_acceptEnd;
   }
   public LocalDate getOc_classStart() {
      return oc_classStart;
   }
   public void setOc_classStart(LocalDate oc_classStart) {
      this.oc_classStart = oc_classStart;
   }
   public LocalDate getOc_classEnd() {
      return oc_classEnd;
   }
   public void setOc_classEnd(LocalDate oc_classEnd) {
      this.oc_classEnd = oc_classEnd;
   }
   public int getOc_appliNum() {
      return oc_appliNum;
   }
   public void setOc_appliNum(int oc_appliNum) {
      this.oc_appliNum = oc_appliNum;
   }
   public String getOc_day() {
      return oc_day;
   }
   public void setOc_day(String oc_day) {
      this.oc_day = oc_day;
   }
   public String getOc_epi() {
      return oc_epi;
   }
   public void setOc_epi(String oc_epi) {
      this.oc_epi = oc_epi;
   }
   public String getC_code() {
      return c_code;
   }
   public void setC_code(String c_code) {
      this.c_code = c_code;
   }
   public String getC_group() {
      return c_group;
   }
   public void setC_group(String c_group) {
      this.c_group = c_group;
   }
   public String getC_name() {
      return c_name;
   }
   public void setC_name(String c_name) {
      this.c_name = c_name;
   }
   public int getC_personnel() {
      return c_personnel;
   }
   public void setC_personnel(int c_personnel) {
      this.c_personnel = c_personnel;
   }
   public String getC_intro() {
      return c_intro;
   }
   public void setC_intro(String c_intro) {
      this.c_intro = c_intro;
   }
   public String getC_material() {
      return c_material;
   }
   public void setC_material(String c_material) {
      this.c_material = c_material;
   }
   public String getCt_code() {
      return ct_code;
   }
   public void setCt_code(String ct_code) {
      this.ct_code = ct_code;
   }
   public String getCt_name() {
      return ct_name;
   }
   public void setCt_name(String ct_name) {
      this.ct_name = ct_name;
   }
   public String getCt_facName() {
      return ct_facName;
   }
   public void setCt_facName(String ct_facName) {
      this.ct_facName = ct_facName;
   }
   public String getCt_facKind() {
      return ct_facKind;
   }
   public void setCt_facKind(String ct_facKind) {
      this.ct_facKind = ct_facKind;
   }
   public String getCt_address() {
      return ct_address;
   }
   public void setCt_address(String ct_address) {
      this.ct_address = ct_address;
   }
   public String getCt_tel() {
      return ct_tel;
   }
   public void setCt_tel(String ct_tel) {
      this.ct_tel = ct_tel;
   }
   public String getCt_Ava() {
      return ct_Ava;
   }
   public void setCt_Ava(String ct_Ava) {
      this.ct_Ava = ct_Ava;
   }
   public String getEp_epi() {
      return ep_epi;
   }
   public void setEp_epi(String ep_epi) {
      this.ep_epi = ep_epi;
   }
   public String getEp_useStart() {
      return ep_useStart;
   }
   public void setEp_useStart(String ep_useStart) {
      this.ep_useStart = ep_useStart;
   }
   public String getEp_useEnd() {
      return ep_useEnd;
   }
   public void setEp_useEnd(String ep_useEnd) {
      this.ep_useEnd = ep_useEnd;
   }
   public String getT_code() {
      return t_code;
   }
   public void setT_code(String t_code) {
      this.t_code = t_code;
   }
   public String getT_name() {
      return t_name;
   }
   public void setT_name(String t_name) {
      this.t_name = t_name;
   } 
   
   
}