package xyz.kraken.domain;

import lombok.Data;

@Data
public class PageDTO {
   private int startPage;
   private int endPage;
   private boolean prev;
   private boolean next;
   
   private int total;
   private Criteria cri;
   
   public PageDTO(Criteria cri, int total){
      this.cri = cri;
      this.total = total;
      
      endPage = (cri.getPageNum()+ 9) / 10 * 10;
      startPage = endPage - 9;
      
      int realEnd = (total + 9) /10;
      endPage = realEnd < endPage ? realEnd : endPage;
      
      prev = startPage > 1;
      next= endPage < realEnd;
   }
}