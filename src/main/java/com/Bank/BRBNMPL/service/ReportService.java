package com.Bank.BRBNMPL.service;

import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.repo.BankGuranteeRepo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private BankGuranteeRepo bankGuranteeRepo;


   public Workbook generateReport(List<BankGuarantee> bankGuarantees){
       Workbook workbook = new XSSFWorkbook();
       Sheet sheet = workbook.createSheet("bgData");
       Row headerRow = sheet.createRow(0);
       String[] headers;
      headers = new String[]{
              "serialNumber","entryDate", "bgNumber","bgDate","typeOfBg","vendor","poWoNumber", "poWoDate", "natureOfSupply", "currency", "amount",
              "bankName", "validityDate", "claimDate", "amendmentValidityDate", "amendmentClaimDate","receivedDate", "receivedFromDept","returnedDate","returnedToDept","status"
      };
       for (int i = 0; i < headers.length; i++) {
           Cell cell = headerRow.createCell(i);
           cell.setCellValue(headers[i]);
       }
   for(int rowIndex=0;rowIndex<bankGuarantees.size();rowIndex++){
       Row dataRow = sheet.createRow(rowIndex+1);
       BankGuarantee bankGuarantee=bankGuarantees.get(rowIndex);
         dataRow.createCell(0).setCellValue(bankGuarantee.getSerialNumber());
         dataRow.createCell(1).setCellValue(bankGuarantee.getEntryDate());
         dataRow.createCell(2).setCellValue(bankGuarantee.getBgNumber());
         if(bankGuarantee.getBgDate()!=null) {
             dataRow.createCell(3).setCellValue(bankGuarantee.getBgDate());
         }
         if(bankGuarantee.getTypeOfBg()!=null) {
             dataRow.createCell(4).setCellValue(bankGuarantee.getTypeOfBg());
         }
         if(bankGuarantee.getVendor()!=null) {
             dataRow.createCell(5).setCellValue(bankGuarantee.getVendor());
         }
         if(bankGuarantee.getPoWoNumber()!=null) {
             dataRow.createCell(6).setCellValue(bankGuarantee.getPoWoNumber());
         }
         if(bankGuarantee.getPoWoDate()!=null) {
             dataRow.createCell(7).setCellValue(bankGuarantee.getPoWoDate());
         }
         if(bankGuarantee.getNatureOfSupply()!=null) {
             dataRow.createCell(8).setCellValue(bankGuarantee.getNatureOfSupply());
         }
         if(bankGuarantee.getCurrency()!=null) {
             dataRow.createCell(9).setCellValue(bankGuarantee.getCurrency());
         }
         if(bankGuarantee.getAmount()!=null) {
             dataRow.createCell(10).setCellValue(bankGuarantee.getAmount());
         }
         if(bankGuarantee.getBankName()!=null) {
             dataRow.createCell(11).setCellValue(bankGuarantee.getBankName());
         }
         if(bankGuarantee.getValidityDate()!=null) {
             dataRow.createCell(12).setCellValue(bankGuarantee.getValidityDate());
         }
         if(bankGuarantee.getClaimDate()!=null) {
             dataRow.createCell(13).setCellValue(bankGuarantee.getClaimDate());
         }
         if(bankGuarantee.getAmendmentClaimDate()!=null) {
             dataRow.createCell(14).setCellValue(bankGuarantee.getAmendmentClaimDate());
         }
         if(bankGuarantee.getAmendmentValidityDate()!=null) {
             dataRow.createCell(15).setCellValue(bankGuarantee.getAmendmentValidityDate());
         }
         if(bankGuarantee.getReceivedDate()!=null) {
             dataRow.createCell(16).setCellValue(bankGuarantee.getReceivedDate());
         }
         if(bankGuarantee.getReceivedDate()!=null) {
             dataRow.createCell(17).setCellValue(bankGuarantee.getReceivedFromDept());
         }
         if(bankGuarantee.getReturnedDate()!=null) {
             dataRow.createCell(18).setCellValue(bankGuarantee.getReturnedDate());
         }
         if(bankGuarantee.getReturnedToDept()!=null) {
             dataRow.createCell(19).setCellValue(bankGuarantee.getReturnedToDept());
         }
         if(bankGuarantee.getStatus()!=null) {
             dataRow.createCell(20).setCellValue(bankGuarantee.getStatus());
         }
   }
   return workbook;
   }

}
