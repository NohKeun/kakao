package com.kakao.deposit;

import com.kakao.deposit.iomodel.CreditInput;
import com.kakao.deposit.iomodel.DebitInput;
import com.kakao.deposit.service.CreditService;
import com.kakao.deposit.service.DebitService;
import com.kakao.deposit.service.OpenService;
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
    private OpenService openService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private DebitService debitService;

    @PostMapping("/open")
    public ResponseEntity<String> open(@RequestBody CreditInput input) throws Exception {
        log.debug("open start");
        openService.execute();

        return ResponseEntity.ok("open");
    }

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestBody CreditInput input) throws Exception {
        log.debug("credit start");
        creditService.execute();

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/debit")
    public ResponseEntity<String> debit(@RequestBody DebitInput input) throws Exception {
        log.debug("debit start");
        debitService.execute();

        return ResponseEntity.ok("Success");
    }
}
