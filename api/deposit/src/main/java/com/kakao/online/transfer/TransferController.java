package com.kakao.online.transfer;

import com.kakao.online.transfer.iomodel.TransferInput;
import com.kakao.online.transfer.service.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transfer")
@RestController
public class TransferController {

    @Autowired
    private Transfer transfer;

    @PostMapping("/send")
    public String insertAppVersion(@RequestBody TransferInput input) throws Exception {

        transfer.send();

        return null;
    }
}
