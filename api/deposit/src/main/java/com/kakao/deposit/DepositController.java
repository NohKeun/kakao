package com.kakao.deposit;

import com.kakao.deposit.iomodel.CreditServiceInput;
import com.kakao.deposit.iomodel.DebitServiceInput;
import com.kakao.deposit.iomodel.DebitServiceOutput;
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
    public ResponseEntity<String> open() throws Exception {
        log.debug("open start");
        openService.execute();

        return ResponseEntity.ok("open");
    }

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestBody CreditServiceInput input) throws Exception {
        log.debug("credit start");
        creditService.execute();

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/debit")
    public ResponseEntity<DebitServiceOutput> debit(@RequestBody DebitServiceInput input) throws Exception {
        log.debug("debit start");
        DebitServiceOutput output = debitService.execute(input);

        return ResponseEntity.ok(output);
    }
}
