package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.Fac_SubsDao;
import com.bodyguard.gyudok.model.dto.Fac_Use;
import com.bodyguard.gyudok.model.dto.Fac_Zzim;
import com.bodyguard.gyudok.model.dto.Facility;
import com.bodyguard.gyudok.model.dto.Fit_Subs;

@Service
public class Fac_SubsServiceImpl implements Fac_SubsService {

	private Fac_SubsDao fac_subsDao;

	public Fac_SubsServiceImpl(Fac_SubsDao fac_subsDao) {
		this.fac_subsDao = fac_subsDao;
	}

	// 운동 시설 구독 신청
	@Override
	public int facSubs(Fit_Subs fit_subs) {
		return fac_subsDao.insertFacSubs(fit_subs);
	}

	// 운동시설 구독 현황 조회하기
	@Override
	public Fit_Subs showfacSubs(String user_id) {
		return fac_subsDao.selectFacSubs(user_id);
	}

	// 운동시설 과거 구독 내역 조회하기
	@Override
	public List<Fit_Subs> showfacSubsHistory(String user_id) {
		return fac_subsDao.selectFacSubHistory(user_id);
	}

	// 운동시설 검색 기능 // 키워드 없으면 전체 조회? -> 단, 매퍼에서 갯수 제한하자(10개)
	// 검색가능 키워드: 시군구, 시설명, 운동 종류
	@Override
	public List<Facility> searchFacs(String keyword) {
		return fac_subsDao.selectFacs(keyword);
	}

	// 운동시설 상세 조회
	@Override
	public Facility showFac(int id) {
		return fac_subsDao.selectFac(id);
	}

	// 운동시설 이용하기
	@Override
	public int useFac(Fac_Use fac_use) {
		return fac_subsDao.insertUseFac(fac_use);
	}

	// 운동시설 이용내역 조회하기
	@Override
	public List<Facility> facUseHistory(String user_id) {
		return fac_subsDao.selectFacUseHistory(user_id);
	}

	// 운동시설 찜하기
	@Override
	public int registFacZzim(Fac_Zzim fac_zzim) {
		return fac_subsDao.insertFacZzim(fac_zzim);
	}

	// 운동시설 찜 삭제하기
	@Override
	public int removeFacZzim(Fac_Zzim fac_zzim) {
		return fac_subsDao.deleteFacZzim(fac_zzim);
	}

	@Override
	public List<Facility> showFacZzims(String user_id) {
		return fac_subsDao.selectFacZzims(user_id);
	}






}
