package org.csu.jpetstore.controller;

/**
 * Created by sun on 2019/12/2
 */
import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.uitls.TestQQUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ResponseResult
@RestController
@CrossOrigin
public class TestQQController {

    @GetMapping("/testQQ/{qq}")
    @ResponseStatus(HttpStatus.OK)
    public PlatformResult testQQ (@PathVariable("qq") String qq) {
        return PlatformResult.success(TestQQUtil.testQQ(qq));
    }

}
