package ru.mycompany.phrase.controller.communication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.service.communication.ReactionService;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public/communication/reaction")
public class ReactionController {

    private final ReactionService reactionService;



    @DeleteMapping("/unblockUser/{blockUserId}")
    public ResponseEntity<Response> unblockUser(@RequestHeader String accessToken, @PathVariable long blockUserId) {

        log.info("START endpoint unblockUser accessToken: {}, commentId: {}", accessToken, blockUserId);
        ResponseEntity<Response> resp = reactionService.unblockUser(accessToken, blockUserId);
        log.info("END endpoint unblockUser, response: {}", resp);
        return resp;
    }



    @GetMapping("/getBlockUsers")
    public ResponseEntity<Response> getBlockUsers(@RequestHeader String accessToken) {

        log.info("START endpoint getBlockUsers  accessToken: {}", accessToken);
        ResponseEntity<Response> resp = reactionService.getBlockUsers(accessToken);
        log.info("END endpoint getBlockUsers, response: {}", resp);
        return resp;
    }



    @PostMapping("/blockUser/{blockUserId}")
    public ResponseEntity<Response> blockUser(@RequestHeader String accessToken, @PathVariable long blockUserId) {

        log.info("START endpoint blockUser  accessToken: {}, commentId: {}", accessToken, blockUserId);
        ResponseEntity<Response> resp = reactionService.blockUser(accessToken, blockUserId);
        log.info("END endpoint blockUser, response: {}", resp);
        return resp;
    }



    @DeleteMapping("/deleteCommentPhrase/{commentId}")
    public ResponseEntity<Response> deleteCommentPhrase(@RequestHeader String accessToken, @PathVariable long commentId) {

        log.info("START endpoint deleteCommentPhrase  accessToken: {}, commentId: {}", accessToken, commentId);
        ResponseEntity<Response> resp = reactionService.deleteCommentPhrase(accessToken, commentId);
        log.info("END endpoint deleteCommentPhrase, response: {}", resp);
        return resp;
    }



    @PostMapping("/commentPhrase")
    public ResponseEntity<Response> commentPhrase(@RequestHeader String accessToken, @RequestBody final CommentPhraseReq req) {

        log.info("START endpoint commentPhrase  accessToken: {}, req: {}", accessToken, req);
        ResponseEntity<Response> resp = reactionService.commentPhrase(accessToken, req);
        log.info("END endpoint commentPhrase, response: {}", resp);
        return resp;
    }



    @DeleteMapping("/deleteLikePhrase/{phraseId}")
    public ResponseEntity<Response> deleteLikePhrase(@RequestHeader String accessToken, @PathVariable long phraseId) {

        log.info("START endpoint deleteLikePhrase  accessToken: {}, phraseId: {}", accessToken, phraseId);
        ResponseEntity<Response> resp = reactionService.deleteLikePhrase(accessToken, phraseId);
        log.info("END endpoint deleteLikePhrase, response: {}", resp);
        return resp;
    }



    @PostMapping("/likePhrase/{phraseId}")
    public ResponseEntity<Response> likePhrase(@RequestHeader String accessToken, @PathVariable long phraseId) {

        log.info("START endpoint likePhrase  accessToken: {}, phraseId: {}", accessToken, phraseId);
        ResponseEntity<Response> resp = reactionService.likePhrase(accessToken, phraseId);
        log.info("END endpoint likePhrase, response: {}", resp);
        return resp;
    }
}
