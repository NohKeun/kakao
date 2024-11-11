package com.kakao.api;

import com.kakao.api.debit.iomodel.DebitInput;
import com.kakao.api.debit.service.DebitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/deposit")
@RestController
public class DepositController {

    @Autowired
    private DebitService debitService;

    @PostMapping("/debit")
    public ResponseEntity<String> debit(@RequestBody DebitInput input) throws Exception {
        log.debug("debit start");
        debitService.debit();

        return ResponseEntity.ok("Success");
    }
}
