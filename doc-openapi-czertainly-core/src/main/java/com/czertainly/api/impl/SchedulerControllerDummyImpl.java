package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.SchedulerController;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import com.czertainly.api.model.core.scheduler.ScheduledJobDetailDto;
import com.czertainly.api.model.core.scheduler.ScheduledJobHistoryResponseDto;
import com.czertainly.api.model.core.scheduler.ScheduledJobsResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerControllerDummyImpl implements SchedulerController {

    @Override
    public ScheduledJobsResponseDto listScheduledJobs(PaginationRequestDto pagination) {
        return null;
    }

    @Override
    public ScheduledJobDetailDto getScheduledJobDetail(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteScheduledJob(String uuid) throws NotFoundException {

    }

    @Override
    public ScheduledJobHistoryResponseDto getScheduledJobHistory(PaginationRequestDto pagination, String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void enableScheduledJob(String uuid) throws NotFoundException {

    }

    @Override
    public void disableScheduledJob(String uuid) throws NotFoundException {

    }
}
