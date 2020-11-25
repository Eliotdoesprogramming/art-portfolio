package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.COMMISSION_STATUS;
import com.talentpath.artportfolio.models.CommissionRequest;

import java.util.List;

public interface CommissionDao {
    Integer addCommissionRequest(CommissionRequest req);
    List<CommissionRequest> getCommissionRequests();
    boolean updateStatus(Integer id, COMMISSION_STATUS status);

    List<CommissionRequest> getPendingCommissions();

     CommissionRequest getCommissionRequestById(Integer id);
}
