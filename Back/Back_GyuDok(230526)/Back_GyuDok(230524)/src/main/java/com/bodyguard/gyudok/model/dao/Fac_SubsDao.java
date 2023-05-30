package com.bodyguard.gyudok.model.dao;

import java.util.List;
import com.bodyguard.gyudok.model.dto.Fac_Use;
import com.bodyguard.gyudok.model.dto.Fac_Zzim;
import com.bodyguard.gyudok.model.dto.Facility;
import com.bodyguard.gyudok.model.dto.Fit_Subs;

public interface Fac_SubsDao {
	// 운동 시설 구독 신청
	int insertFacSubs(Fit_Subs fit_subs);

	// 운동시설 구독 현황 조회하기
	Fit_Subs selectFacSubs(String user_id);

	// 운동시설 과거 구독 내역 조회하기
	List<Fit_Subs> selectFacSubHistory(String user_id);

	// 운동시설 검색 기능 // 키워드 없으면 전체 조회? -> 단, 매퍼에서 갯수 제한하자(10개)
	List<Facility> selectFacs(String keyword);

	// 운동시설 상세 조회
	Facility selectFac(int id);

	// 운동시설 이용하기
	int insertUseFac(Fac_Use fac_use);

	// 운동시설 이용내역 조회하기
	List<Facility> selectFacUseHistory(String user_id);

	// 운동시설 찜하기
	int insertFacZzim(Fac_Zzim fac_zzim);

	// 운동시설 찜 삭제하기
	int deleteFacZzim(Fac_Zzim fac_zzim);

	// 운동시설 찜 목록 조회
	List<Facility> selectFacZzims(String user_id);

}
