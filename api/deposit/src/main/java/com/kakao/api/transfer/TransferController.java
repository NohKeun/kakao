package com.kakao.api.transfer;

import com.kakao.api.transfer.iomodel.TransferInput;
import com.kakao.api.transfer.service.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/transfer")
@Controller
public class TransferController {

    @Autowired
    private Transfer transfer;

    @PostMapping("/send")
    public String send(@RequestBody TransferInput input) throws Exception {
        log.debug("aaa");
        transfer.send();

        return "abc";
    }
}
