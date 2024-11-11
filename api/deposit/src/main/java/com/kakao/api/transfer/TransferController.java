package com.kakao.api.transfer;

import com.kakao.api.transfer.iomodel.TransferInput;
import com.kakao.api.transfer.service.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/transfer")
@RestController
public class TransferController {

    @Autowired
    private Transfer transfer;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody TransferInput input) throws Exception {
        log.debug("aaa");
        transfer.send();

        return ResponseEntity.ok("Success");
    }
}
