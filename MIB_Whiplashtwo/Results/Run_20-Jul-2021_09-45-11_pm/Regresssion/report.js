$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/unrep/journey2.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 2",
  "description": "",
  "id": "journey-2",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Unrep claim creation with Multi VRN",
  "description": "",
  "id": "journey-2;unrep-claim-creation-with-multi-vrn",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "unrep logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter all mandatory details for claim creation as \u0027\u003cowner\u003e\u0027 , \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cct_preference\u003e\u0027 with \u0027\u003cmultivrn\u003e\u0027,\u0027\u003clocation\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "journey-2;unrep-claim-creation-with-multi-vrn;",
  "rows": [
    {
      "cells": [
        "owner",
        "involvement_type_v",
        "ct_preference",
        "multivrn",
        "location"
      ],
      "line": 10,
      "id": "journey-2;unrep-claim-creation-with-multi-vrn;;1"
    },
    {
      "cells": [
        "NO",
        "I was a passenger in a Car/Lorry/Van",
        "BOTH",
        "YES",
        "Inside UK"
      ],
      "line": 11,
      "id": "journey-2;unrep-claim-creation-with-multi-vrn;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9466229600,
  "status": "passed"
});
formatter.before({
  "duration": 424000,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Unrep claim creation with Multi VRN",
  "description": "",
  "id": "journey-2;unrep-claim-creation-with-multi-vrn;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "unrep logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter all mandatory details for claim creation as \u0027NO\u0027 , \u0027I was a passenger in a Car/Lorry/Van\u0027 and \u0027BOTH\u0027 with \u0027YES\u0027,\u0027Inside UK\u0027",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.user_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 84812015400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "NO",
      "offset": 56
    },
    {
      "val": "I was a passenger in a Car/Lorry/Van",
      "offset": 63
    },
    {
      "val": "BOTH",
      "offset": 106
    },
    {
      "val": "YES",
      "offset": 118
    },
    {
      "val": "Inside UK",
      "offset": 124
    }
  ],
  "location": "ClaimantActionsStepDefs.user_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String,String,String)"
});
formatter.result({
  "duration": 638764765500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_Reference_Number_Unrep_Is_Created_Successfully()"
});
formatter.result({
  "duration": 35795458000,
  "status": "passed"
});
formatter.after({
  "duration": 2046837000,
  "status": "passed"
});
formatter.before({
  "duration": 6834943900,
  "status": "passed"
});
formatter.before({
  "duration": 194600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "CSR allocates claim to  compensator",
  "description": "",
  "id": "journey-2;csr-allocates-claim-to--compensator",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Claim received by csr and eligible for assigning to compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "CSR assigns compensator",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Claim is sent to respective compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "CSRStepDefs.claim_received_by_csr()"
});
formatter.result({
  "duration": 60703734400,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.csr_assigns_compensator()"
});
formatter.result({
  "duration": 398000838000,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.claim_sent_to_compensator()"
});
formatter.result({
  "duration": 8827249800,
  "status": "passed"
});
formatter.after({
  "duration": 1906870300,
  "status": "passed"
});
formatter.before({
  "duration": 6764515600,
  "status": "passed"
});
formatter.before({
  "duration": 123400,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Compensator  Accept Claim and denies Liability",
  "description": "",
  "id": "journey-2;compensator--accept-claim-and-denies-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "compensator denies full liability",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the claims acceptance and liability is now sent to the claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 68334971100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_denies_full_liability()"
});
formatter.result({
  "duration": 116880304900,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_full_liability_sent_claimant()"
});
formatter.result({
  "duration": 12557142800,
  "status": "passed"
});
formatter.after({
  "duration": 1968259400,
  "status": "passed"
});
formatter.before({
  "duration": 6206716900,
  "status": "passed"
});
formatter.before({
  "duration": 261100,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Claimant Challenge Decision and goes to court",
  "description": "",
  "id": "journey-2;claimant-challenge-decision-and-goes-to-court",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "Claimant claim liability has been rejected",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "claimant challenges and goes to court",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "the claimant goes to court",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_liability_rejected()"
});
formatter.result({
  "duration": 57848346500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_challenges_go_to_court()"
});
formatter.result({
  "duration": 64884993800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claimant_goes_to_court()"
});
formatter.result({
  "duration": 12910970400,
  "status": "passed"
});
formatter.after({
  "duration": 1912188000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 29,
  "name": "Compensator review and agrees to claimant court document",
  "description": "",
  "id": "journey-2;compensator-review-and-agrees-to-claimant-court-document",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 30,
  "name": "claimant selects court documents compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "Compensator agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "the claim can be Resolved",
  "keyword": "Then "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": "journey-2;compensator-review-and-agrees-to-claimant-court-document;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 35,
      "id": "journey-2;compensator-review-and-agrees-to-claimant-court-document;;1"
    },
    {
      "cells": [
        "Pending-LiabilityListReview"
      ],
      "line": 36,
      "id": "journey-2;compensator-review-and-agrees-to-claimant-court-document;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5985968200,
  "status": "passed"
});
formatter.before({
  "duration": 149200,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Compensator review and agrees to claimant court document",
  "description": "",
  "id": "journey-2;compensator-review-and-agrees-to-claimant-court-document;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "claimant selects court documents compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "Compensator agrees to court documents when claim is in \u0027Pending-LiabilityListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "the claim can be Resolved",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_select_court_docs()"
});
formatter.result({
  "duration": 62693897500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-LiabilityListReview",
      "offset": 56
    }
  ],
  "location": "CompensatorStepDefs.compensator_agree_court_documents(String)"
});
formatter.result({
  "duration": 66845572400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_resolved()"
});
formatter.result({
  "duration": 12062899400,
  "status": "passed"
});
formatter.after({
  "duration": 1903741100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "unrep Claimant checks the documents selected by compensator and submit the claim for court",
  "description": "",
  "id": "journey-2;unrep-claimant-checks-the-documents-selected-by-compensator-and-submit-the-claim-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "\u0027\u003cClaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "claimant submits the court documents for liability",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "Case is closed with Go to court at offer stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 42,
  "name": "",
  "description": "",
  "id": "journey-2;unrep-claimant-checks-the-documents-selected-by-compensator-and-submit-the-claim-for-court;",
  "rows": [
    {
      "cells": [
        "Claimant"
      ],
      "line": 43,
      "id": "journey-2;unrep-claimant-checks-the-documents-selected-by-compensator-and-submit-the-claim-for-court;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 44,
      "id": "journey-2;unrep-claimant-checks-the-documents-selected-by-compensator-and-submit-the-claim-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6535147200,
  "status": "passed"
});
formatter.before({
  "duration": 693000,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "unrep Claimant checks the documents selected by compensator and submit the claim for court",
  "description": "",
  "id": "journey-2;unrep-claimant-checks-the-documents-selected-by-compensator-and-submit-the-claim-for-court;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 39,
  "name": "\u0027unrep\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "claimant submits the court documents for liability",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "Case is closed with Go to court at offer stage",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_verifies_documents_from_compensator(String)"
});
formatter.result({
  "duration": 48229247600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_submits_court_documents_for_liability()"
});
formatter.result({
  "duration": 96966109600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.go_to_court_claim_closed()"
});
formatter.result({
  "duration": 14660562300,
  "status": "passed"
});
formatter.after({
  "duration": 2228057400,
  "status": "passed"
});
formatter.before({
  "duration": 6173108700,
  "status": "passed"
});
formatter.before({
  "duration": 285800,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "Compensator reopens claim and accepts full claim liability",
  "description": "",
  "id": "journey-2;compensator-reopens-claim-and-accepts-full-claim-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 47,
  "name": "claimant uploads court documents",
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "compensator reopens liability disputed claim",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "compensator accepts full liability",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_uploads_court_documents()"
});
formatter.result({
  "duration": 58203901500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_repoens_liability_disputed_claim()"
});
formatter.result({
  "duration": 87971240500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_accepts_full_liability()"
});
formatter.result({
  "duration": 12274377300,
  "status": "passed"
});
formatter.after({
  "duration": 2240845400,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 53,
      "value": "#################### Sprint 41 #########################"
    }
  ],
  "line": 55,
  "name": "Claimant Request first Interim Payment",
  "description": "",
  "id": "journey-2;claimant-request-first-interim-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 56,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "\u0027\u003cclaimant\u003e\u0027 requests interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "interim payment request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 59,
  "name": "",
  "description": "",
  "id": "journey-2;claimant-request-first-interim-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 60,
      "id": "journey-2;claimant-request-first-interim-payment;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 61,
      "id": "journey-2;claimant-request-first-interim-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5843503800,
  "status": "passed"
});
formatter.before({
  "duration": 312700,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "Claimant Request first Interim Payment",
  "description": "",
  "id": "journey-2;claimant-request-first-interim-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 56,
  "name": "claim has been accepted for \u0027unrep\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "\u0027unrep\u0027 requests interim payment",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "interim payment request is sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 29
    }
  ],
  "location": "ClaimantActionsStepDefs.claim_has_been_accepted(String)"
});
formatter.result({
  "duration": 65791958700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_first_interim_payment(String)"
});
formatter.result({
  "duration": 40619996900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.interim_payment_request_compensator()"
});
formatter.result({
  "duration": 14583082200,
  "status": "passed"
});
formatter.after({
  "duration": 1904144200,
  "status": "passed"
});
formatter.before({
  "duration": 5901159700,
  "status": "passed"
});
formatter.before({
  "duration": 142100,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Compensator makes first interim payment",
  "description": "",
  "id": "journey-2;compensator-makes-first-interim-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 64,
  "name": "claimant request interm payment to compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "compensator makes interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "claimant receives interim payment",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.request_interim_payment_compensator()"
});
formatter.result({
  "duration": 53467615200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_makes_interim_payment()"
});
formatter.result({
  "duration": 80603222400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_receives_interim_payment()"
});
formatter.result({
  "duration": 11899501500,
  "status": "passed"
});
formatter.after({
  "duration": 2132072300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 68,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-2;claimant-reviews-and-accepts-first-interim-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 69,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "\u0027\u003cclaimant\u003e\u0027 reviews and accept interim decision",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "payment is not received by the claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 72,
  "name": "",
  "description": "",
  "id": "journey-2;claimant-reviews-and-accepts-first-interim-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 73,
      "id": "journey-2;claimant-reviews-and-accepts-first-interim-payment;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 74,
      "id": "journey-2;claimant-reviews-and-accepts-first-interim-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7121747500,
  "status": "passed"
});
formatter.before({
  "duration": 141500,
  "status": "passed"
});
formatter.scenario({
  "line": 74,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-2;claimant-reviews-and-accepts-first-interim-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 69,
  "name": "claim has been accepted for \u0027unrep\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "\u0027unrep\u0027 reviews and accept interim decision",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "payment is not received by the claimant",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 29
    }
  ],
  "location": "ClaimantActionsStepDefs.claim_has_been_accepted(String)"
});
formatter.result({
  "duration": 73232855700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_reviews_accept_interim_decision(String)"
});
formatter.result({
  "duration": 42567779300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.payment_not_received_the_claimant()"
});
formatter.result({
  "duration": 370161887200,
  "status": "passed"
});
formatter.after({
  "duration": 2011681600,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 77,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-2;claimant-decides-to-go-to-court-for-interim-over-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 78,
  "name": "\u0027\u003cclaimant\u003e\u0027 interim non-payment SLA is breached",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "Go to court for non-payment option is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 80,
  "name": "claimant decides to go to court over interim non-payment",
  "keyword": "Then "
});
formatter.examples({
  "line": 81,
  "name": "",
  "description": "",
  "id": "journey-2;claimant-decides-to-go-to-court-for-interim-over-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 82,
      "id": "journey-2;claimant-decides-to-go-to-court-for-interim-over-non-payment;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 83,
      "id": "journey-2;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6875282400,
  "status": "passed"
});
formatter.before({
  "duration": 205400,
  "status": "passed"
});
formatter.scenario({
  "line": 83,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-2;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 78,
  "name": "\u0027unrep\u0027 interim non-payment SLA is breached",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "Go to court for non-payment option is enabled for \u0027unrep\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 80,
  "name": "claimant decides to go to court over interim non-payment",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.interim_payment_sla_breached(String)"
});
formatter.result({
  "duration": 43453503400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 51
    }
  ],
  "location": "ClaimantActionsStepDefs.gotocourt_non_payment_option(String)"
});
formatter.result({
  "duration": 25045454600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_goto_court_for_non_payment()"
});
formatter.result({
  "duration": 15277280300,
  "status": "passed"
});
formatter.after({
  "duration": 2294729900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 86,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-2;claimant-select-court-docs-for-interim-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 87,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court over interim",
  "keyword": "Given "
});
formatter.step({
  "line": 88,
  "name": "\u0027\u003cclaimant\u003e\u0027 selects interim docs for court with Court proceeding No",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "court document are sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 91,
  "name": "",
  "description": "",
  "id": "journey-2;claimant-select-court-docs-for-interim-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 92,
      "id": "journey-2;claimant-select-court-docs-for-interim-non-payment;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 93,
      "id": "journey-2;claimant-select-court-docs-for-interim-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6234170200,
  "status": "passed"
});
formatter.before({
  "duration": 140100,
  "status": "passed"
});
formatter.scenario({
  "line": 93,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-2;claimant-select-court-docs-for-interim-non-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 87,
  "name": "\u0027unrep\u0027 goes to court over interim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 88,
  "name": "\u0027unrep\u0027 selects interim docs for court with Court proceeding No",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "court document are sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_goes_to_court_over_interim(String)"
});
formatter.result({
  "duration": 43124767700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.unrep_selects_interim_docs_for_court_with_Court_proceeding_No(String)"
});
formatter.result({
  "duration": 62792121300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.court_documents_are_to_compensator()"
});
formatter.result({
  "duration": 12813274800,
  "status": "passed"
});
formatter.after({
  "duration": 1944751600,
  "status": "passed"
});
formatter.before({
  "duration": 6601910000,
  "status": "passed"
});
formatter.before({
  "duration": 77600,
  "status": "passed"
});
formatter.scenario({
  "line": 96,
  "name": "Compensator reviews court document for Interim non-payment",
  "description": "",
  "id": "journey-2;compensator-reviews-court-document-for-interim-non-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 97,
  "name": "claimant goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 98,
  "name": "Compensator reviews court document for interim",
  "keyword": "When "
});
formatter.step({
  "line": 99,
  "name": "court docs sent for review to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_goes_to_court()"
});
formatter.result({
  "duration": 40311581100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_reviews_court_document_interim()"
});
formatter.result({
  "duration": 72953966100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.court_sent_for_review_to_claimant()"
});
formatter.result({
  "duration": 11579455000,
  "status": "passed"
});
formatter.after({
  "duration": 1844389900,
  "status": "passed"
});
formatter.before({
  "duration": 6699443600,
  "status": "passed"
});
formatter.before({
  "duration": 470300,
  "status": "passed"
});
formatter.scenario({
  "line": 101,
  "name": "Unrep acknowledges documents selected by compensator",
  "description": "",
  "id": "journey-2;unrep-acknowledges-documents-selected-by-compensator",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 102,
  "name": "compensator confirmed documents selected by claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 103,
  "name": "claimant acknowledges selected documents with proceeding No",
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "Interim case is resolved at court",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.compensator_confirmed_documents_selected_claimant()"
});
formatter.result({
  "duration": 36673483700,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_ack_selected_docs_with_proceeding_No()"
});
formatter.result({
  "duration": 380758311600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.interim_case_resolved()"
});
formatter.result({
  "duration": 12814132300,
  "status": "passed"
});
formatter.after({
  "duration": 1990237200,
  "status": "passed"
});
formatter.before({
  "duration": 5557320800,
  "status": "passed"
});
formatter.before({
  "duration": 477800,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 106,
      "value": "###########################################################"
    }
  ],
  "line": 109,
  "name": "Unrep Provides Medical Preferences",
  "description": "",
  "id": "journey-2;unrep-provides-medical-preferences",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 110,
  "name": "the unrep claim moves to partial liability",
  "keyword": "Given "
});
formatter.step({
  "line": 111,
  "name": "unrep chooses DME after reopening claim",
  "keyword": "When "
});
formatter.step({
  "line": 112,
  "name": "medical preferences are sent to Independent Expert",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_partial_liability()"
});
formatter.result({
  "duration": 40554983500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_choose_dme_after_reopeing_claim()"
});
formatter.result({
  "duration": 308014925200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.medical_preferences_sent_experts()"
});
formatter.result({
  "duration": 13714743500,
  "status": "passed"
});
formatter.after({
  "duration": 2341984600,
  "status": "passed"
});
formatter.before({
  "duration": 8086295000,
  "status": "passed"
});
formatter.before({
  "duration": 89767800,
  "status": "passed"
});
formatter.scenario({
  "line": 114,
  "name": "DME uploads report-No prognosis",
  "description": "",
  "id": "journey-2;dme-uploads-report-no-prognosis",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 115,
  "name": "claimant selects DME",
  "keyword": "Given "
});
formatter.step({
  "line": 116,
  "name": "claimant visits DME and completes checkup",
  "keyword": "When "
});
formatter.step({
  "line": 117,
  "name": "DME uploads report no prognosis",
  "keyword": "Then "
});
formatter.match({
  "location": "DMEDefs.claimant_selects_dme()"
});
formatter.result({
  "duration": 66100925400,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.claimant_visits_dme_complete_checkup()"
});
formatter.result({
  "duration": 303825748800,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.dme_upload_report_no_prognosis()"
});
formatter.result({
  "duration": 11635639300,
  "status": "passed"
});
formatter.after({
  "duration": 1998172500,
  "status": "passed"
});
formatter.before({
  "duration": 6664333300,
  "status": "passed"
});
formatter.before({
  "duration": 449900,
  "status": "passed"
});
formatter.scenario({
  "line": 119,
  "name": "Claimant selects option \u0027No\u0027 for the question \"Do you believe the facts in the medical report are complete and correct?\" and request for further medical",
  "description": "",
  "id": "journey-2;claimant-selects-option-\u0027no\u0027-for-the-question-\"do-you-believe-the-facts-in-the-medical-report-are-complete-and-correct?\"-and-request-for-further-medical",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 120,
  "name": "medical report is sent to claimant for review",
  "keyword": "Given "
});
formatter.step({
  "line": 121,
  "name": "Claimant Adds fee from losses tile",
  "keyword": "And "
});
formatter.step({
  "line": 122,
  "name": "Claimant requests for second report",
  "keyword": "When "
});
formatter.step({
  "line": 123,
  "name": "Claimant need to visit DME for medical examination again",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.medical_report_sent_to_claimant_review()"
});
formatter.result({
  "duration": 63484527100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_add_fee_loss_tile()"
});
formatter.result({
  "duration": 328042455100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_requests_second_report()"
});
formatter.result({
  "duration": 846983878500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_need_to_visit_dme()"
});
formatter.result({
  "duration": 14010297800,
  "status": "passed"
});
formatter.after({
  "duration": 2101234300,
  "status": "passed"
});
formatter.before({
  "duration": 6570685600,
  "status": "passed"
});
formatter.before({
  "duration": 1379800,
  "status": "passed"
});
formatter.scenario({
  "line": 125,
  "name": "DME  uploads medical Report with waitout period before prognosis",
  "description": "",
  "id": "journey-2;dme--uploads-medical-report-with-waitout-period-before-prognosis",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 126,
  "name": "Claimant requests further medical report after marking factually incorrect",
  "keyword": "Given "
});
formatter.step({
  "line": 127,
  "name": "DME upload further report",
  "keyword": "When "
});
formatter.step({
  "line": 128,
  "name": "Report is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "DMEDefs.claimant_requests_further_medical_report_factually_incorrect()"
});
formatter.result({
  "duration": 95203675200,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.dme_uploads_further_report()"
});
formatter.result({
  "duration": 338576576400,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.report_is_sent_to_claimant()"
});
formatter.result({
  "duration": 9805966900,
  "status": "passed"
});
formatter.after({
  "duration": 1832705100,
  "status": "passed"
});
formatter.before({
  "duration": 5749893800,
  "status": "passed"
});
formatter.before({
  "duration": 171700,
  "status": "passed"
});
formatter.scenario({
  "line": 130,
  "name": "Claimants proceeds to offer",
  "description": "",
  "id": "journey-2;claimants-proceeds-to-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 131,
  "name": "Claimant waitout Prognosis period is completed",
  "keyword": "Given "
});
formatter.step({
  "line": 132,
  "name": "unrep claimant proceeds with offer",
  "keyword": "When "
});
formatter.step({
  "line": 133,
  "name": "claim will be sent to compensator for review",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_waitout_prognosis_period_is_completed()"
});
formatter.result({
  "duration": 63302344500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_proceed_with_offer()"
});
formatter.result({
  "duration": 423448137500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_sent_to_compensator_for_review()"
});
formatter.result({
  "duration": 12879813100,
  "status": "passed"
});
formatter.after({
  "duration": 1859643600,
  "status": "passed"
});
formatter.before({
  "duration": 6432496900,
  "status": "passed"
});
formatter.before({
  "duration": 235500,
  "status": "passed"
});
formatter.scenario({
  "line": 135,
  "name": "Compensator makes First Offer with fee proposal",
  "description": "",
  "id": "journey-2;compensator-makes-first-offer-with-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 136,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 137,
  "name": "the compensator makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 138,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 38826663500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_makes_first_offer_with_fee_proposal_mibprouser()"
});
formatter.result({
  "duration": 194942109600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 20797358800,
  "status": "passed"
});
formatter.after({
  "duration": 1790010200,
  "status": "passed"
});
formatter.before({
  "duration": 6146378900,
  "status": "passed"
});
formatter.before({
  "duration": 139100,
  "status": "passed"
});
formatter.scenario({
  "line": 140,
  "name": "Unrep Claimant accepts offer",
  "description": "",
  "id": "journey-2;unrep-claimant-accepts-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 141,
  "name": "Claimant received offer details",
  "keyword": "Given "
});
formatter.step({
  "line": 142,
  "name": "Claimant accepts offer",
  "keyword": "When "
});
formatter.step({
  "line": 143,
  "name": "Acknowledgement for offer acceptance will be sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_received_offer_details()"
});
formatter.result({
  "duration": 41460699100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_accepts_offer()"
});
formatter.result({
  "duration": 36699034600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.acknowledgement_for_offer_acceptance_will_be_sent_to_compensator()"
});
formatter.result({
  "duration": 12873758400,
  "status": "passed"
});
formatter.after({
  "duration": 1694099400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 145,
  "name": "Compensator acknowledges offer",
  "description": "",
  "id": "journey-2;compensator-acknowledges-offer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 146,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 147,
  "name": "Compensator acknowledges claimants offer with claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 148,
  "name": "the claim can be Resolved",
  "keyword": "Then "
});
formatter.examples({
  "line": 149,
  "name": "",
  "description": "",
  "id": "journey-2;compensator-acknowledges-offer;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 150,
      "id": "journey-2;compensator-acknowledges-offer;;1"
    },
    {
      "cells": [
        "Pending-Acknowledgement"
      ],
      "line": 151,
      "id": "journey-2;compensator-acknowledges-offer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5865818500,
  "status": "passed"
});
formatter.before({
  "duration": 145000,
  "status": "passed"
});
formatter.scenario({
  "line": 151,
  "name": "Compensator acknowledges offer",
  "description": "",
  "id": "journey-2;compensator-acknowledges-offer;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.step({
  "line": 146,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 147,
  "name": "Compensator acknowledges claimants offer with claim \u0027Pending-Acknowledgement\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 148,
  "name": "the claim can be Resolved",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 39378571300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-Acknowledgement",
      "offset": 53
    }
  ],
  "location": "CompensatorStepDefs.compensator_acknowledges_claimants_offer(String)"
});
formatter.result({
  "duration": 37973980600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_resolved()"
});
formatter.result({
  "duration": 10890476600,
  "status": "passed"
});
formatter.after({
  "duration": 1787501000,
  "status": "passed"
});
});