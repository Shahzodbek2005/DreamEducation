package com.bluebird.DreamEducation.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ResultData {
   private Boolean status;
   private Object result;

   public ResultData(Boolean status, Object result) {
      this.status = status;
      this.result = result;
   }

   public Boolean getStatus() {
      return status;
   }

   public void setStatus(Boolean status) {
      this.status = status;
   }

   public Object getResult() {
      return result;
   }

   public void setResult(Object result) {
      this.result = result;
   }
}
