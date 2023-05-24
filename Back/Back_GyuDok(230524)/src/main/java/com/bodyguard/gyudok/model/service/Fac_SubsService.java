package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Fac_Use;
import com.bodyguard.gyudok.model.dto.Fac_Zzim;
import com.bodyguard.gyudok.model.dto.Facility;
import com.bodyguard.gyudok.model.dto.Fit_Subs;

public interface Fac_SubsService {

	int facSubs(Fit_Subs fit_subs);

	Fit_Subs showfacSubs(String user_id);

	List<Fit_Subs> showfacSubsHistory(String user_id);

	List<Facility> searchFacs(String keyword);

	Facility showFac(int id);

	int useFac(Fac_Use fac_use);

	List<Facility> facUseHistory(String user_id);

	int registFacZzim(Fac_Zzim fac_zzim);
	
	int removeFacZzim(Fac_Zzim fac_zzim);

	List<Facility> showFacZzims(String user_id);

}
