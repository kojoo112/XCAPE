package com.samsan.xcape.controller;

import com.samsan.xcape.enums.ApiResultEnum;
import com.samsan.xcape.service.HintService;
import com.samsan.xcape.vo.HintVO;
import com.samsan.xcape.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class HintController {

    private final HintService hintService;

    public HintController(HintService hintService) {
        this.hintService = hintService;
    }

    @GetMapping("/theme/list")
    public ResponseEntity<ApiResult> getThemeList(String merchantCode) {
        ApiResult apiResult = new ApiResult(hintService.getThemeList(merchantCode));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity(apiResult, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/merchant/list")
    public ResponseEntity<ApiResult> getMerchantList(UserVO userVO){
        ApiResult apiResult = new ApiResult(hintService.getMerchantList(userVO));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity<>(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity<>(apiResult, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/hint/list")
    public ResponseEntity<ApiResult> getHintList(HintVO hintVO) {
        ApiResult apiResult = new ApiResult(hintService.getHintList(hintVO));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/registerHint")
    public ResponseEntity<ApiResult> registerHint(@RequestBody HintVO hintVO) {
        ApiResult apiResult = new ApiResult(hintService.registerHint(hintVO));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity<>(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity<>(apiResult, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/modifyMessage")
    public ResponseEntity<ApiResult> modifyMessage(@RequestBody HintVO hintVO) {
        ApiResult apiResult = new ApiResult(hintService.modifyMessage(hintVO));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity<>(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity<>(apiResult, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/hint/{seq}")
    public ResponseEntity<ApiResult> deleteHint(@PathVariable int seq) {
        log.info(">>> HintController.deleteHint > {}", seq);
        ApiResult apiResult = new ApiResult(hintService.deleteHint(seq));

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modifyHintCode")
    public ResponseEntity<ApiResult> modifyHintCode(String key, int seq) {
        ApiResult apiResult = new ApiResult(hintService.modifyHintCode(key, seq));

//        boolean isModified = (boolean) apiResult.getInfo();
//        if (isModified) {
//            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
//            return new ResponseEntity<>(apiResult, HttpStatus.OK);
//        } else {
//            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
//            return new ResponseEntity<>(apiResult, HttpStatus.BAD_REQUEST);
//        }

        if (apiResult.getReturnCode().getBooleanResult()) {
            apiResult.setApiResultEnum(ApiResultEnum.SUCCESS);
            return new ResponseEntity(apiResult, HttpStatus.OK);
        } else {
            apiResult.setApiResultEnum(ApiResultEnum.FAIL);
            return new ResponseEntity(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
