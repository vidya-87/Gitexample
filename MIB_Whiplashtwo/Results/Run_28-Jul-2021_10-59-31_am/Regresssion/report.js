$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey39.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 39",
  "description": "",
  "id": "journey-39",
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
  "id": "journey-39;prouser-submit-a-claim-as-passenger-in-a-car",
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
  "id": "journey-39;prouser-submit-a-claim-as-passenger-in-a-car;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 11,
      "id": "journey-39;prouser-submit-a-claim-as-passenger-in-a-car;;1"
    },
    {
      "cells": [
        "A passenger on a bus",
        "NO",
        "NO"
      ],
      "line": 12,
      "id": "journey-39;prouser-submit-a-claim-as-passenger-in-a-car;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9979077700,
  "status": "passed"
});
formatter.before({
  "duration": 152000,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Prouser Submit a Claim as passenger in a car",
  "description": "",
  "id": "journey-39;prouser-submit-a-claim-as-passenger-in-a-car;;2",
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
  "name": "prouser enter all mandatory details for claim creation as \u0027A passenger on a bus\u0027 and \u0027NO\u0027 and \u0027NO\u0027",
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
  "duration": 38759543600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A passenger on a bus",
      "offset": 59
    },
    {
      "val": "NO",
      "offset": 86
    },
    {
      "val": "NO",
      "offset": 95
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String)"
});
formatter.result({
  "duration": 466778791700,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 44496993300,
  "status": "passed"
});
formatter.after({
  "duration": 1802043100,
  "status": "passed"
});
formatter.before({
  "duration": 6251043900,
  "status": "passed"
});
formatter.before({
  "duration": 103600,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-39;compensator-receives-claim-and-claim-liability-sent-to-tpa",
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
  "duration": 42174359900,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 36003290500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 11133720300,
  "status": "passed"
});
formatter.after({
  "duration": 1909999000,
  "status": "passed"
});
formatter.before({
  "duration": 6749811200,
  "status": "passed"
});
formatter.before({
  "duration": 92200,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "TPA disputes causation and admits full liability",
  "description": "",
  "id": "journey-39;tpa-disputes-causation-and-admits-full-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "TPA accepts full liability",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 50340082400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 108477001300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 12033007900,
  "status": "passed"
});
formatter.after({
  "duration": 1733565100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 25,
  "name": "Claimant Request first Interim Payment",
  "description": "",
  "id": "journey-39;claimant-request-first-interim-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "\u0027\u003cclaimant\u003e\u0027 requests interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "interim payment request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "journey-39;claimant-request-first-interim-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 30,
      "id": "journey-39;claimant-request-first-interim-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 31,
      "id": "journey-39;claimant-request-first-interim-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5311027800,
  "status": "passed"
});
formatter.before({
  "duration": 101000,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Claimant Request first Interim Payment",
  "description": "",
  "id": "journey-39;claimant-request-first-interim-payment;;2",
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
  "line": 26,
  "name": "claim has been accepted for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "\u0027prouser\u0027 requests interim payment",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 28,
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
  "duration": 73857309800,
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
  "duration": 63227283900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.interim_payment_request_compensator()"
});
formatter.result({
  "duration": 11496780500,
  "status": "passed"
});
formatter.after({
  "duration": 1683222100,
  "status": "passed"
});
formatter.before({
  "duration": 6203559700,
  "status": "passed"
});
formatter.before({
  "duration": 84500,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Compensator makes first interim payment",
  "description": "",
  "id": "journey-39;compensator-makes-first-interim-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 34,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "compensator makes interim payment",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "claimant receives interim payment",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 39483792200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_makes_interim_payment()"
});
formatter.result({
  "duration": 63867556600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claimant_receives_interim_payment()"
});
formatter.result({
  "duration": 10494019200,
  "status": "passed"
});
formatter.after({
  "duration": 1737522300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-39;claimant-reviews-and-accepts-first-interim-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "claim has been accepted for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "\u0027\u003cclaimant\u003e\u0027 reviews and accept interim decision",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "payment is not received by the claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 42,
  "name": "",
  "description": "",
  "id": "journey-39;claimant-reviews-and-accepts-first-interim-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 43,
      "id": "journey-39;claimant-reviews-and-accepts-first-interim-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 44,
      "id": "journey-39;claimant-reviews-and-accepts-first-interim-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4529245700,
  "status": "passed"
});
formatter.before({
  "duration": 70400,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Claimant reviews and accepts first interim payment",
  "description": "",
  "id": "journey-39;claimant-reviews-and-accepts-first-interim-payment;;2",
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
  "line": 39,
  "name": "claim has been accepted for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "\u0027prouser\u0027 reviews and accept interim decision",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 41,
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
  "duration": 34950160000,
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
  "duration": 57920536200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.payment_not_received_the_claimant()"
});
formatter.result({
  "duration": 368027337700,
  "status": "passed"
});
formatter.after({
  "duration": 1765257500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 47,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-39;claimant-decides-to-go-to-court-for-interim-over-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 48,
  "name": "\u0027\u003cclaimant\u003e\u0027 interim non-payment SLA is breached",
  "keyword": "Given "
});
formatter.step({
  "line": 49,
  "name": "Go to court for non-payment option is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "claimant decides to go to court over interim non-payment",
  "keyword": "Then "
});
formatter.examples({
  "line": 51,
  "name": "",
  "description": "",
  "id": "journey-39;claimant-decides-to-go-to-court-for-interim-over-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 52,
      "id": "journey-39;claimant-decides-to-go-to-court-for-interim-over-non-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 53,
      "id": "journey-39;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6395915400,
  "status": "passed"
});
formatter.before({
  "duration": 88500,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "Claimant decides to go to court for interim over non-payment",
  "description": "",
  "id": "journey-39;claimant-decides-to-go-to-court-for-interim-over-non-payment;;2",
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
  "line": 48,
  "name": "\u0027prouser\u0027 interim non-payment SLA is breached",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 49,
  "name": "Go to court for non-payment option is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 50,
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
  "duration": 34555251200,
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
  "duration": 48633136000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_goto_court_for_non_payment()"
});
formatter.result({
  "duration": 11993686300,
  "status": "passed"
});
formatter.after({
  "duration": 1738321500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 55,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-39;claimant-select-court-docs-for-interim-non-payment",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 56,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court over interim",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "\u0027\u003cclaimant\u003e\u0027 selects document for court for interim non-payment",
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "court document are sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 60,
  "name": "",
  "description": "",
  "id": "journey-39;claimant-select-court-docs-for-interim-non-payment;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 61,
      "id": "journey-39;claimant-select-court-docs-for-interim-non-payment;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 62,
      "id": "journey-39;claimant-select-court-docs-for-interim-non-payment;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6583389300,
  "status": "passed"
});
formatter.before({
  "duration": 100600,
  "status": "passed"
});
formatter.scenario({
  "line": 62,
  "name": "Claimant select court docs for interim non-payment",
  "description": "",
  "id": "journey-39;claimant-select-court-docs-for-interim-non-payment;;2",
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
  "line": 56,
  "name": "\u0027prouser\u0027 goes to court over interim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "\u0027prouser\u0027 selects document for court for interim non-payment",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 58,
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
  "duration": 32935631700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_submits_document_for_court(String)"
});
formatter.result({
  "duration": 96836243800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.court_documents_are_to_compensator()"
});
formatter.result({
  "duration": 11497358400,
  "status": "passed"
});
formatter.after({
  "duration": 1806273200,
  "status": "passed"
});
formatter.before({
  "duration": 5779903100,
  "status": "passed"
});
formatter.before({
  "duration": 108100,
  "status": "passed"
});
formatter.scenario({
  "line": 64,
  "name": "Compensator reviews court document for Interim non-payment",
  "description": "",
  "id": "journey-39;compensator-reviews-court-document-for-interim-non-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 65,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 66,
  "name": "Compensator reviews court document for interim",
  "keyword": "When "
});
formatter.step({
  "line": 67,
  "name": "court docs sent for review to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 40348146700,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_reviews_court_document_interim()"
});
formatter.result({
  "duration": 59944092200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.court_sent_for_review_to_claimant()"
});
formatter.result({
  "duration": 10313320000,
  "status": "passed"
});
formatter.after({
  "duration": 1965488200,
  "status": "passed"
});
formatter.before({
  "duration": 5353876700,
  "status": "passed"
});
formatter.before({
  "duration": 89300,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-39;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 70,
  "name": "prouser receives claim for acknowledgement",
  "keyword": "Given "
});
formatter.step({
  "line": 71,
  "name": "prouser claimant acknowledge for Interim",
  "keyword": "When "
});
formatter.step({
  "line": 72,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_receives_the_claim_for_acknowledgement()"
});
formatter.result({
  "duration": 37623091500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claimant_acknowledge_for_Interim()"
});
formatter.result({
  "duration": 108301102500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 8402006300,
  "status": "passed"
});
formatter.after({
  "duration": 1775928500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 75,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-39;prouser-uploads-medical-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 76,
  "name": "upload medical report is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "\"\u003cclaimant\u003e\" uploads medical report with Uplift request",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 79,
  "name": "",
  "description": "",
  "id": "journey-39;prouser-uploads-medical-report;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 80,
      "id": "journey-39;prouser-uploads-medical-report;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 81,
      "id": "journey-39;prouser-uploads-medical-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5405816200,
  "status": "passed"
});
formatter.before({
  "duration": 287000,
  "status": "passed"
});
formatter.scenario({
  "line": 81,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-39;prouser-uploads-medical-report;;2",
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
  "line": 76,
  "name": "upload medical report is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "\"prouser\" uploads medical report with Uplift request",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 78,
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
  "duration": 32978872300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.uploads_medical_report_with_Uplift_request(String)"
});
formatter.result({
  "duration": 222052212300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 12417217800,
  "status": "passed"
});
formatter.after({
  "duration": 1775066400,
  "status": "passed"
});
formatter.before({
  "duration": 6078460900,
  "status": "passed"
});
formatter.before({
  "duration": 93400,
  "status": "passed"
});
formatter.scenario({
  "line": 84,
  "name": "TPA First Offer to Prouser",
  "description": "",
  "id": "journey-39;tpa-first-offer-to-prouser",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 85,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 86,
  "name": "the TPA makes first offer with NON whiplash injury with uplift",
  "keyword": "When "
});
formatter.step({
  "line": 87,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 32494628000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.the_TPA_makes_first_offer_with_NON_whiplash_injury_with_uplift()"
});
formatter.result({
  "duration": 196760796600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 20210783400,
  "status": "passed"
});
formatter.after({
  "duration": 1798459900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 89,
  "name": "Prouser rejects offer and goes to court",
  "description": "",
  "id": "journey-39;prouser-rejects-offer-and-goes-to-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 90,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives new offer",
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "\"\u003cclaimant\u003e\" decided to go to court after rejecting first offer",
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 93,
  "name": "",
  "description": "",
  "id": "journey-39;prouser-rejects-offer-and-goes-to-court;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 94,
      "id": "journey-39;prouser-rejects-offer-and-goes-to-court;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 95,
      "id": "journey-39;prouser-rejects-offer-and-goes-to-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6043708400,
  "status": "passed"
});
formatter.before({
  "duration": 73900,
  "status": "passed"
});
formatter.scenario({
  "line": 95,
  "name": "Prouser rejects offer and goes to court",
  "description": "",
  "id": "journey-39;prouser-rejects-offer-and-goes-to-court;;2",
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
  "line": 90,
  "name": "\u0027prouser\u0027 receives new offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "\"prouser\" decided to go to court after rejecting first offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.receives_new_offer(String)"
});
formatter.result({
  "duration": 36015619400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.decided_to_go_to_court_after_rejecting_first_offer(String)"
});
formatter.result({
  "duration": 117143616200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11629410500,
  "status": "passed"
});
formatter.after({
  "duration": 1727692800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 98,
  "name": "Prouser selected Court proceeding started and selected documents for court",
  "description": "",
  "id": "journey-39;prouser-selected-court-proceeding-started-and-selected-documents-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 99,
  "name": "\"\u003cclaimant\u003e\" started court proceeding",
  "keyword": "Given "
});
formatter.step({
  "line": 100,
  "name": "\"\u003cclaimant\u003e\" selected Court proceeding started as Yes",
  "keyword": "When "
});
formatter.step({
  "line": 101,
  "name": "\"\u003cclaimant\u003e\" selected documents for court",
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "documents sent to TPA",
  "keyword": "Then "
});
formatter.examples({
  "line": 103,
  "name": "",
  "description": "",
  "id": "journey-39;prouser-selected-court-proceeding-started-and-selected-documents-for-court;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 104,
      "id": "journey-39;prouser-selected-court-proceeding-started-and-selected-documents-for-court;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 105,
      "id": "journey-39;prouser-selected-court-proceeding-started-and-selected-documents-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6008193800,
  "status": "passed"
});
formatter.before({
  "duration": 65400,
  "status": "passed"
});
formatter.scenario({
  "line": 105,
  "name": "Prouser selected Court proceeding started and selected documents for court",
  "description": "",
  "id": "journey-39;prouser-selected-court-proceeding-started-and-selected-documents-for-court;;2",
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
  "line": 99,
  "name": "\"prouser\" started court proceeding",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 100,
  "name": "\"prouser\" selected Court proceeding started as Yes",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 101,
  "name": "\"prouser\" selected documents for court",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "documents sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.started_court_proceeding(String)"
});
formatter.result({
  "duration": 34155463400,
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
  "duration": 95931564500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.selected_documents_for_court(String)"
});
formatter.result({
  "duration": 82722370400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.documents_sent_to_TPA()"
});
formatter.result({
  "duration": 20393238200,
  "status": "passed"
});
formatter.after({
  "duration": 1719528200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 107,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-39;tpa-acknowledges-documents-selected-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 108,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 109,
  "name": "TPA agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 110,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 111,
  "name": "",
  "description": "",
  "id": "journey-39;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 112,
      "id": "journey-39;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-OfferListReview"
      ],
      "line": 113,
      "id": "journey-39;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5625150600,
  "status": "passed"
});
formatter.before({
  "duration": 82300,
  "status": "passed"
});
formatter.scenario({
  "line": 113,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-39;tpa-acknowledges-documents-selected-for-court;;2",
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
  "line": 108,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 109,
  "name": "TPA agrees to court documents when claim is in \u0027Pending-OfferListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 110,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_select_court_docs_tpa()"
});
formatter.result({
  "duration": 31399798300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-OfferListReview",
      "offset": 48
    }
  ],
  "location": "TPAStepDefs.tpa_agree_court_documents(String)"
});
formatter.result({
  "duration": 52994349700,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20477723300,
  "status": "passed"
});
formatter.after({
  "duration": 1912339000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 115,
  "name": "Claimant checks the documents selected by TPA and proceeds the claim for court",
  "description": "",
  "id": "journey-39;claimant-checks-the-documents-selected-by-tpa-and-proceeds-the-claim-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 116,
  "name": "\u0027\u003cclaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 117,
  "name": "\"\u003cclaimant\u003e\" entered details in court screen",
  "keyword": "When "
});
formatter.step({
  "line": 118,
  "name": "Case is closed with Go to court at offer stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 119,
  "name": "",
  "description": "",
  "id": "journey-39;claimant-checks-the-documents-selected-by-tpa-and-proceeds-the-claim-for-court;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 120,
      "id": "journey-39;claimant-checks-the-documents-selected-by-tpa-and-proceeds-the-claim-for-court;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 121,
      "id": "journey-39;claimant-checks-the-documents-selected-by-tpa-and-proceeds-the-claim-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4736905100,
  "status": "passed"
});
formatter.before({
  "duration": 8342200,
  "status": "passed"
});
formatter.scenario({
  "line": 121,
  "name": "Claimant checks the documents selected by TPA and proceeds the claim for court",
  "description": "",
  "id": "journey-39;claimant-checks-the-documents-selected-by-tpa-and-proceeds-the-claim-for-court;;2",
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
  "line": 116,
  "name": "\u0027prouser\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 117,
  "name": "\"prouser\" entered details in court screen",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 118,
  "name": "Case is closed with Go to court at offer stage",
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
  "duration": 34284729300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.entered_details_in_court_screen(String)"
});
formatter.result({
  "duration": 193003706400,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.go_to_court_claim_closed()"
});
formatter.result({
  "duration": 11829049200,
  "status": "passed"
});
formatter.after({
  "duration": 1857247300,
  "status": "passed"
});
});