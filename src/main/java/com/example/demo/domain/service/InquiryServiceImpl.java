package com.example.demo.domain.service;

import com.example.demo.infrastructure.entity.Inquiry;
import com.example.demo.infrastructure.repository.InquiryDao;

import java.util.List;

/*
 * Add an annotation here
 */
public class InquiryServiceImpl implements InquiryService {

    private final InquiryDao dao;

    public InquiryServiceImpl(InquiryDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Inquiry inquiry) {
        //hands-on
    }

//  This method is used in the latter chapter
//	@Override
//	public void update(Inquiry inquiry) {
//
//		//return dao.updateInquiry(inquiry);
//		if(dao.updateInquiry(inquiry) == 0) {
//			throw new InquiryNotFoundException("can't find the same ID");
//		}
//	}

    @Override
    public List<Inquiry> getAll() {

        //hands-on

        return null;
    }
}
