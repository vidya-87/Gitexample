$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey40.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 40",
  "description": "",
  "id": "journey-40",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Prouser Submit a Claim as passenger in a car",
  "description": "",
  "id": "journey-40;prouser-submit-a-claim-as-passenger-in-a-car",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "prouser enter all mandatory details for claim creation as \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cowner\u003e\u0027 and \u0027\u003cmultivrn\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "journey-40;prouser-submit-a-claim-as-passenger-in-a-car;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 11,
      "id": "journey-40;prouser-submit-a-claim-as-passenger-in-a-car;;1"
    },
    {
      "cells": [
        "The driver",
        "YES",
        "NO"
      ],
      "line": 12,
      "id": "journey-40;prouser-submit-a-claim-as-passenger-in-a-car;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8616047300,
  "status": "passed"
});
formatter.before({
  "duration": 210500,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Prouser Submit a Claim as passenger in a car",
  "description": "",
  "id": "journey-40;prouser-submit-a-claim-as-passenger-in-a-car;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "prouser enter all mandatory details for claim creation as \u0027The driver\u0027 and \u0027YES\u0027 and \u0027NO\u0027",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 38257499000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "The driver",
      "offset": 59
    },
    {
      "val": "YES",
      "offset": 76
    },
    {
      "val": "NO",
      "offset": 86
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String)"
});
formatter.result({
  "duration": 463616830400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 43410772800,
  "status": "passed"
});
formatter.after({
  "duration": 1709747700,
  "status": "passed"
});
formatter.before({
  "duration": 5850682700,
  "status": "passed"
});
formatter.before({
  "duration": 104900,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-40;compensator-receives-claim-and-claim-liability-sent-to-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "compensator receives claim and send to TPA",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "claims acceptance and liability decision is now sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 37909084800,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 35173005900,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10556369800,
  "status": "passed"
});
formatter.after({
  "duration": 1584400000,
  "status": "passed"
});
formatter.before({
  "duration": 5882428400,
  "status": "passed"
});
formatter.before({
  "duration": 110500,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "TPA  Denies Claim and claim Liability",
  "description": "",
  "id": "journey-40;tpa--denies-claim-and-claim-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "the claim  has been sent to the TPA workbasket",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "TPA dispute claim liability",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claim_has_been_sent_to_TPA()"
});
formatter.result({
  "duration": 45047563500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_claim__denies_claim_liability()"
});
formatter.result({
  "duration": 118121858600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 8469009400,
  "status": "passed"
});
formatter.after({
  "duration": 1638813800,
  "status": "passed"
});
formatter.before({
  "duration": 5494869900,
  "status": "passed"
});
formatter.before({
  "duration": 85000,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Prouser challenge decision and go to court and submit documents",
  "description": "",
  "id": "journey-40;prouser-challenge-decision-and-go-to-court-and-submit-documents",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Prouser claim liability has been rejected",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "prouser wants to challenge decision and decided to go to court",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "the claimant goes to court",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claim_liability_rejected()"
});
formatter.result({
  "duration": 37997788800,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_challenge_decision_go_to_court()"
});
formatter.result({
  "duration": 99592108400,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claimant_goes_to_court()"
});
formatter.result({
  "duration": 11598772300,
  "status": "passed"
});
formatter.after({
  "duration": 1642836100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 29,
  "name": "TPA disagree for document selection",
  "description": "",
  "id": "journey-40;tpa-disagree-for-document-selection",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 30,
  "name": "Uploaded documents for court cofirmed by Claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "TPA disagrees to court documents uploaded by Claimant at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "claimant need to review the documents uploaded by TPA",
  "keyword": "Then "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "journey-40;tpa-disagree-for-document-selection;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 34,
      "id": "journey-40;tpa-disagree-for-document-selection;;1"
    },
    {
      "cells": [
        "Pending-LiabilityListReview"
      ],
      "line": 35,
      "id": "journey-40;tpa-disagree-for-document-selection;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5964624900,
  "status": "passed"
});
formatter.before({
  "duration": 124500,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "TPA disagree for document selection",
  "description": "",
  "id": "journey-40;tpa-disagree-for-document-selection;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "Uploaded documents for court cofirmed by Claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "TPA disagrees to court documents uploaded by Claimant at \u0027Pending-LiabilityListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "claimant need to review the documents uploaded by TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.court_documents_confirmed_claimant()"
});
formatter.result({
  "duration": 38154326300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-LiabilityListReview",
      "offset": 58
    }
  ],
  "location": "TPAStepDefs.tpa_disagrees_court_document_from_claimant(String)"
});
formatter.result({
  "duration": 60132682700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claimant_review_the_documents_uploaded_tpa()"
});
formatter.result({
  "duration": 8289279000,
  "status": "passed"
});
formatter.after({
  "duration": 1633564500,
  "status": "passed"
});
formatter.before({
  "duration": 6566532300,
  "status": "passed"
});
formatter.before({
  "duration": 71100,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-40;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "prouser receives claim for acknowledgement",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "prouser claimant acknowledge for liability challenge",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_receives_the_claim_for_acknowledgement()"
});
formatter.result({
  "duration": 41970023500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_acknowledge_liability_challenge()"
});
formatter.result({
  "duration": 134064384600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 8266508000,
  "status": "passed"
});
formatter.after({
  "duration": 1641842500,
  "status": "passed"
});
formatter.before({
  "duration": 5458476200,
  "status": "passed"
});
formatter.before({
  "duration": 97100,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "TPA reopens claim and make full liability to claimant",
  "description": "",
  "id": "journey-40;tpa-reopens-claim-and-make-full-liability-to-claimant",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "Claim is resolved at court",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "TPA reopens liability disputed claim",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "TPA accepts full liability after reopening the claim",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_uploads_court_documents()"
});
formatter.result({
  "duration": 42254600000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_repoens_liability_disputed_claim()"
});
formatter.result({
  "duration": 82724278200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability_after_reopen()"
});
formatter.result({
  "duration": 10501396100,
  "status": "passed"
});
formatter.after({
  "duration": 1771725800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 49,
  "name": "Claimant Request first Interim Payment and added fees",
  "description": "",
  "id": "journey-40;claimant-request-first-interim-payment-and-added-fees",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 50,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "\u0027\u003cclaimant\u003e\u0027 requests interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "\u0027\u003cclaimant\u003e\u0027 adds fee",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "interim payment request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 54,
  "name": "",
  "description": "",
  "id": "journey-40;claimant-request-first-interim-payment-and-added-fees;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 55,
      "id": "journey-40;claimant-request-first-interim-payment-and-added-fees;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 56,
      "id": "journey-40;claimant-request-first-interim-payment-and-added-fees;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5470581900,
  "status": "passed"
});
formatter.before({
  "duration": 128800,
  "status": "passed"
});
formatter.scenario({
  "line": 56,
  "name": "Claimant Request first Interim Payment and added fees",
  "description": "",
  "id": "journey-40;claimant-request-first-interim-payment-and-added-fees;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 50,
  "name": "claim has been accepted for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "\u0027prouser\u0027 requests interim payment",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "\u0027prouser\u0027 adds fee",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "interim payment request is sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 29
    }
  ],
  "location": "ClaimantActionsStepDefs.claim_has_been_accepted(String)"
});
formatter.result({
  "duration": 45220795700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_first_interim_payment(String)"
});
formatter.result({
  "duration": 56398060000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimants_add_fee(String)"
});
formatter.result({
  "duration": 64340338300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.interim_payment_request_compensator()"
});
formatter.result({
  "duration": 11342005500,
  "status": "passed"
});
formatter.after({
  "duration": 1740647300,
  "status": "passed"
});
formatter.before({
  "duration": 6032463400,
  "status": "passed"
});
formatter.before({
  "duration": 125100,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "Compensator makes first interim payment",
  "description": "",
  "id": "journey-40;compensator-makes-first-interim-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 59,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 60,
  "name": "compensator makes interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "claimant receives interim payment",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 41856367300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_makes_interim_payment()"
});
formatter.result({
  "duration": 62661620600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_receives_interim_payment()"
});
formatter.result({
  "duration": 10437424000,
  "status": "passed"
});
formatter.after({
  "duration": 1693743200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 63,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-40;claimant-reviews-and-accepts-first-interim-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 64,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "\u0027\u003cclaimant\u003e\u0027 reviews and accept interim decision",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "payment is not received by the claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 67,
  "name": "",
  "description": "",
  "id": "journey-40;claimant-reviews-and-accepts-first-interim-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 68,
      "id": "journey-40;claimant-reviews-and-accepts-first-interim-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 69,
      "id": "journey-40;claimant-reviews-and-accepts-first-interim-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5814354300,
  "status": "passed"
});
formatter.before({
  "duration": 161500,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-40;claimant-reviews-and-accepts-first-interim-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 64,
  "name": "claim has been accepted for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "\u0027prouser\u0027 reviews and accept interim decision",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "payment is not received by the claimant",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 29
    }
  ],
  "location": "ClaimantActionsStepDefs.claim_has_been_accepted(String)"
});
formatter.result({
  "duration": 31397949200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_reviews_accept_interim_decision(String)"
});
formatter.result({
  "duration": 58395155700,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.payment_not_received_the_claimant()"
});
formatter.result({
  "duration": 367775430500,
  "status": "passed"
});
formatter.after({
  "duration": 1763514500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 72,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-40;claimant-decides-to-go-to-court-for-interim-over-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 73,
  "name": "\u0027\u003cclaimant\u003e\u0027 interim non-payment SLA is breached",
  "keyword": "Given "
});
formatter.step({
  "line": 74,
  "name": "Go to court for non-payment option is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 75,
  "name": "claimant decides to go to court over interim non-payment",
  "keyword": "Then "
});
formatter.examples({
  "line": 76,
  "name": "",
  "description": "",
  "id": "journey-40;claimant-decides-to-go-to-court-for-interim-over-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 77,
      "id": "journey-40;claimant-decides-to-go-to-court-for-interim-over-non-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 78,
      "id": "journey-40;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6113181000,
  "status": "passed"
});
formatter.before({
  "duration": 86000,
  "status": "passed"
});
formatter.scenario({
  "line": 78,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-40;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 73,
  "name": "\u0027prouser\u0027 interim non-payment SLA is breached",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 74,
  "name": "Go to court for non-payment option is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 75,
  "name": "claimant decides to go to court over interim non-payment",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.interim_payment_sla_breached(String)"
});
formatter.result({
  "duration": 43929550900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 51
    }
  ],
  "location": "ClaimantActionsStepDefs.gotocourt_non_payment_option(String)"
});
formatter.result({
  "duration": 49821908100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_goto_court_for_non_payment()"
});
formatter.result({
  "duration": 12230197000,
  "status": "passed"
});
formatter.after({
  "duration": 1581351200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 80,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-40;claimant-select-court-docs-for-interim-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 81,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court over interim",
  "keyword": "Given "
});
formatter.step({
  "line": 82,
  "name": "\"\u003cclaimant\u003e\" selected Court proceeding started as No",
  "keyword": "When "
});
formatter.step({
  "line": 83,
  "name": "\"\u003cclaimant\u003e\" selected documents for court NON payment of Interim",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "court document are sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 86,
  "name": "",
  "description": "",
  "id": "journey-40;claimant-select-court-docs-for-interim-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 87,
      "id": "journey-40;claimant-select-court-docs-for-interim-non-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 88,
      "id": "journey-40;claimant-select-court-docs-for-interim-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5601060000,
  "status": "passed"
});
formatter.before({
  "duration": 67600,
  "status": "passed"
});
formatter.scenario({
  "line": 88,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-40;claimant-select-court-docs-for-interim-non-payment;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 81,
  "name": "\u0027prouser\u0027 goes to court over interim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 82,
  "name": "\"prouser\" selected Court proceeding started as No",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 83,
  "name": "\"prouser\" selected documents for court NON payment of Interim",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "court document are sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_goes_to_court_over_interim(String)"
});
formatter.result({
  "duration": 26982895000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.selected_Court_proceeding_started_as_No(String)"
});
formatter.result({
  "duration": 380371240400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.selected_documents_for_court_NON_payment_of_Interim(String)"
});
formatter.result({
  "duration": 55865129300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.court_documents_are_to_compensator()"
});
formatter.result({
  "duration": 12031514700,
  "status": "passed"
});
formatter.after({
  "duration": 1800432200,
  "status": "passed"
});
formatter.before({
  "duration": 6451626600,
  "status": "passed"
});
formatter.before({
  "duration": 92000,
  "status": "passed"
});
formatter.scenario({
  "line": 90,
  "name": "TPA reviews court document for Interim non-payment",
  "description": "",
  "id": "journey-40;tpa-reviews-court-document-for-interim-non-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 91,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "Compensator reviews court document for interim",
  "keyword": "When "
});
formatter.step({
  "line": 93,
  "name": "court docs sent for review to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 36195507600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_reviews_court_document_interim()"
});
formatter.result({
  "duration": 60204177100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.court_sent_for_review_to_claimant()"
});
formatter.result({
  "duration": 10812467000,
  "status": "passed"
});
formatter.after({
  "duration": 1587642800,
  "status": "passed"
});
formatter.before({
  "duration": 6477080000,
  "status": "passed"
});
formatter.before({
  "duration": 69300,
  "status": "passed"
});
formatter.scenario({
  "line": 95,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-40;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 96,
  "name": "prouser receives claim for acknowledgement",
  "keyword": "Given "
});
formatter.step({
  "line": 97,
  "name": "prouser claimant acknowledge for Interim",
  "keyword": "When "
});
formatter.step({
  "line": 98,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_receives_the_claim_for_acknowledgement()"
});
formatter.result({
  "duration": 41122012700,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claimant_acknowledge_for_Interim()"
});
formatter.result({
  "duration": 110678599900,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 8405327900,
  "status": "passed"
});
formatter.after({
  "duration": 1652843200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 101,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-40;prouser-uploads-medical-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 102,
  "name": "upload medical report is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 103,
  "name": "\"\u003cclaimant\u003e\" uploads medical report without Uplift request",
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 105,
  "name": "",
  "description": "",
  "id": "journey-40;prouser-uploads-medical-report;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 106,
      "id": "journey-40;prouser-uploads-medical-report;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 107,
      "id": "journey-40;prouser-uploads-medical-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6298312200,
  "status": "passed"
});
formatter.before({
  "duration": 143100,
  "status": "passed"
});
formatter.scenario({
  "line": 107,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-40;prouser-uploads-medical-report;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 102,
  "name": "upload medical report is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 103,
  "name": "\"prouser\" uploads medical report without Uplift request",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 38
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_option_upload_medical_report(String)"
});
formatter.result({
  "duration": 45977264500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.uploads_medical_report_without_Uplift_request(String)"
});
formatter.result({
  "duration": 204805617000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 11458366000,
  "status": "passed"
});
formatter.after({
  "duration": 1637810800,
  "status": "passed"
});
formatter.before({
  "duration": 5723548100,
  "status": "passed"
});
formatter.before({
  "duration": 15350500,
  "status": "passed"
});
formatter.scenario({
  "line": 112,
  "name": "TPA makes First Offer with fee proposal",
  "description": "",
  "id": "journey-40;tpa-makes-first-offer-with-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 113,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 114,
  "name": "the TPA makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 115,
  "name": "claim will be sent for claimant acknowledgement",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 38539899600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 196378909800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 8157351400,
  "status": "passed"
});
formatter.after({
  "duration": 1762005500,
  "status": "passed"
});
formatter.before({
  "duration": 5318648400,
  "status": "passed"
});
formatter.before({
  "duration": 96800,
  "status": "passed"
});
formatter.scenario({
  "line": 117,
  "name": "prouser accepts offer and rejects fee proposal",
  "description": "",
  "id": "journey-40;prouser-accepts-offer-and-rejects-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 118,
  "name": "prouser review fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 119,
  "name": "prouser accepts offer and makes counter fees proposal",
  "keyword": "When "
});
formatter.step({
  "line": 120,
  "name": "pro counter offer sent to compensator for review",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_review_fee_proposal()"
});
formatter.result({
  "duration": 40485118300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_accepts_offer_reject_fees_proposal()"
});
formatter.result({
  "duration": 98957130300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_counter_offer_sent_compensator_for_review()"
});
formatter.result({
  "duration": 12384334200,
  "status": "passed"
});
formatter.after({
  "duration": 1663301200,
  "status": "passed"
});
formatter.before({
  "duration": 5966442500,
  "status": "passed"
});
formatter.before({
  "duration": 88500,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 121,
      "value": "####"
    }
  ],
  "line": 123,
  "name": "TPA rejects claimants fee offer",
  "description": "",
  "id": "journey-40;tpa-rejects-claimants-fee-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 124,
  "name": "Prouser rejects fee offer",
  "keyword": "Given "
});
formatter.step({
  "line": 125,
  "name": "TPA rejects claimant fee offer",
  "keyword": "When "
});
formatter.step({
  "line": 126,
  "name": "TPA sends the updated fee offer to prouser",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.prouser_rejects_fee_offer()"
});
formatter.result({
  "duration": 47073346900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_rejects_claimant_fee_offer()"
});
formatter.result({
  "duration": 41066186600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_sends_updated_fee_offer()"
});
formatter.result({
  "duration": 10633221400,
  "status": "passed"
});
formatter.after({
  "duration": 1607907000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 128,
  "name": "prouser go to court for fee proposal",
  "description": "",
  "id": "journey-40;prouser-go-to-court-for-fee-proposal",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 129,
  "name": "Prouser reject fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 130,
  "name": "prouser reject fee offer decided to go to court",
  "keyword": "When "
});
formatter.step({
  "line": 131,
  "name": "\"\u003cclaimant\u003e\" selected Court proceeding started as Yes",
  "keyword": "And "
});
formatter.step({
  "line": 132,
  "name": "\"\u003cclaimant\u003e\" selected documents for court fees disagreement",
  "keyword": "And "
});
formatter.step({
  "line": 133,
  "name": "the claimant goes to court",
  "keyword": "Then "
});
formatter.examples({
  "line": 134,
  "name": "",
  "description": "",
  "id": "journey-40;prouser-go-to-court-for-fee-proposal;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 135,
      "id": "journey-40;prouser-go-to-court-for-fee-proposal;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 136,
      "id": "journey-40;prouser-go-to-court-for-fee-proposal;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5399688100,
  "status": "passed"
});
formatter.before({
  "duration": 51200,
  "status": "passed"
});
formatter.scenario({
  "line": 136,
  "name": "prouser go to court for fee proposal",
  "description": "",
  "id": "journey-40;prouser-go-to-court-for-fee-proposal;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 129,
  "name": "Prouser reject fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 130,
  "name": "prouser reject fee offer decided to go to court",
  "keyword": "When "
});
formatter.step({
  "line": 131,
  "name": "\"prouser\" selected Court proceeding started as Yes",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 132,
  "name": "\"prouser\" selected documents for court fees disagreement",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 133,
  "name": "the claimant goes to court",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_reject_fee_proposal()"
});
formatter.result({
  "duration": 46975473700,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_reject_fee_offer_decided_to_go_to_court()"
});
formatter.result({
  "duration": 60132802100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.selected_Court_proceeding_started_as_Yes(String)"
});
formatter.result({
  "duration": 96221502500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.selected_documents_for_court_fees_disagreement(String)"
});
formatter.result({
  "duration": 57287494500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claimant_goes_to_court()"
});
formatter.result({
  "duration": 11056777300,
  "status": "passed"
});
formatter.after({
  "duration": 1745220700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 138,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-40;tpa-acknowledges-documents-selected-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 139,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 140,
  "name": "TPA agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 141,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 142,
  "name": "",
  "description": "",
  "id": "journey-40;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 143,
      "id": "journey-40;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-FeesListReview"
      ],
      "line": 144,
      "id": "journey-40;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5467173100,
  "status": "passed"
});
formatter.before({
  "duration": 59400,
  "status": "passed"
});
formatter.scenario({
  "line": 144,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-40;tpa-acknowledges-documents-selected-for-court;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 139,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 140,
  "name": "TPA agrees to court documents when claim is in \u0027Pending-FeesListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 141,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_select_court_docs_tpa()"
});
formatter.result({
  "duration": 38318787900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-FeesListReview",
      "offset": 48
    }
  ],
  "location": "TPAStepDefs.tpa_agree_court_documents(String)"
});
formatter.result({
  "duration": 54273753500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20632470800,
  "status": "passed"
});
formatter.after({
  "duration": 1595201200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 146,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-40;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 147,
  "name": "\u0027\u003cclaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 148,
  "name": "\"\u003cclaimant\u003e\" submit the claim for court with claim for fee dispute subsequent court applications",
  "keyword": "When "
});
formatter.step({
  "line": 149,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 150,
  "name": "",
  "description": "",
  "id": "journey-40;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 151,
      "id": "journey-40;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 152,
      "id": "journey-40;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5852148600,
  "status": "passed"
});
formatter.before({
  "duration": 92900,
  "status": "passed"
});
formatter.scenario({
  "line": 152,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-40;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 147,
  "name": "\u0027prouser\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 148,
  "name": "\"prouser\" submit the claim for court with claim for fee dispute subsequent court applications",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 149,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_verifies_documents_from_compensator(String)"
});
formatter.result({
  "duration": 42031401600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.submit_the_claim_for_court_with_claim_for_fee_dispute_subsequent_court_applications(String)"
});
formatter.result({
  "duration": 239621015500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 11116051400,
  "status": "passed"
});
formatter.after({
  "duration": 1676764400,
  "status": "passed"
});
});