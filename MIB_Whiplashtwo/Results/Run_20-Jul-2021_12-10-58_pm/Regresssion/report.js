$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey31.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 31",
  "description": "",
  "id": "journey-31",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-31;prouser-submit-a-claim-as-passenger-in-bus",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "prouser enter all mandatory details for claim creation as \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cowner\u003e\u0027 and \u0027\u003cmultivrn\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "journey-31;prouser-submit-a-claim-as-passenger-in-bus;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 10,
      "id": "journey-31;prouser-submit-a-claim-as-passenger-in-bus;;1"
    },
    {
      "cells": [
        "A passenger on a bus",
        "NO",
        "NO"
      ],
      "line": 11,
      "id": "journey-31;prouser-submit-a-claim-as-passenger-in-bus;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7508940800,
  "status": "passed"
});
formatter.before({
  "duration": 164200,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-31;prouser-submit-a-claim-as-passenger-in-bus;;2",
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
  "line": 5,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "prouser enter all mandatory details for claim creation as \u0027A passenger on a bus\u0027 and \u0027NO\u0027 and \u0027NO\u0027",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 43584284100,
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
  "duration": 471736667400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 44081218600,
  "status": "passed"
});
formatter.after({
  "duration": 1826234000,
  "status": "passed"
});
formatter.before({
  "duration": 6009246600,
  "status": "passed"
});
formatter.before({
  "duration": 89800,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-31;compensator-receives-claim-and-claim-liability-sent-to-tpa",
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
  "duration": 36022478200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 36656981900,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 11070171700,
  "status": "passed"
});
formatter.after({
  "duration": 1753833100,
  "status": "passed"
});
formatter.before({
  "duration": 4940369200,
  "status": "passed"
});
formatter.before({
  "duration": 101000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "TPA accepts full liability",
  "description": "",
  "id": "journey-31;tpa-accepts-full-liability",
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
  "duration": 46800411200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 100353492500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 11199714700,
  "status": "passed"
});
formatter.after({
  "duration": 1862462100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 25,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-31;prouser-uploads-medical-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "upload medical report is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "\u0027\u003cclaimant\u003e\u0027 adds fee",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "claimant uploads medical report at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "journey-31;prouser-uploads-medical-report;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 32,
      "id": "journey-31;prouser-uploads-medical-report;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-Medical"
      ],
      "line": 33,
      "id": "journey-31;prouser-uploads-medical-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4550318200,
  "status": "passed"
});
formatter.before({
  "duration": 115900,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-31;prouser-uploads-medical-report;;2",
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
  "name": "upload medical report is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "\u0027prouser\u0027 adds fee",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "claimant uploads medical report at \u0027Pending-Medical\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
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
  "duration": 40354721900,
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
  "duration": 69258823200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-Medical",
      "offset": 36
    }
  ],
  "location": "ProUserActionsStepDefs.medical_report_prouser(String)"
});
formatter.result({
  "duration": 204496671200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 12288395300,
  "status": "passed"
});
formatter.after({
  "duration": 1800887600,
  "status": "passed"
});
formatter.before({
  "duration": 5792281300,
  "status": "passed"
});
formatter.before({
  "duration": 146100,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "TPA makes First Offer with fee proposal",
  "description": "",
  "id": "journey-31;tpa-makes-first-offer-with-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "the TPA makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "claim offer is sent to claimant review",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 78890772000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 206764406900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_offer_is_sent_to_claimant_review()"
});
formatter.result({
  "duration": 369661026500,
  "status": "passed"
});
formatter.after({
  "duration": 1905585800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 41,
  "name": "TPA withdraws the first offer",
  "description": "",
  "id": "journey-31;tpa-withdraws-the-first-offer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 42,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "TPA withdraws the offer at claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.examples({
  "line": 45,
  "name": "",
  "description": "",
  "id": "journey-31;tpa-withdraws-the-first-offer;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 46,
      "id": "journey-31;tpa-withdraws-the-first-offer;;1"
    },
    {
      "cells": [
        "Pending-ReviewOffer"
      ],
      "line": 47,
      "id": "journey-31;tpa-withdraws-the-first-offer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6434152200,
  "status": "passed"
});
formatter.before({
  "duration": 933700,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "TPA withdraws the first offer",
  "description": "",
  "id": "journey-31;tpa-withdraws-the-first-offer;;2",
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
  "line": 42,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "TPA withdraws the offer at claim \u0027Pending-ReviewOffer\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 42675300400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-ReviewOffer",
      "offset": 34
    }
  ],
  "location": "TPAStepDefs.tpa_withdraws_the_offer_and_rejects_the_offer(String)"
});
formatter.result({
  "duration": 50219196600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.stpa_gets_an_option_to_replace_the_offer()"
});
formatter.result({
  "duration": 9956428900,
  "status": "passed"
});
formatter.after({
  "duration": 1793865500,
  "status": "passed"
});
formatter.before({
  "duration": 6094898400,
  "status": "passed"
});
formatter.before({
  "duration": 148400,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "TPA replace offer",
  "description": "",
  "id": "journey-31;tpa-replace-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 50,
  "name": "TPA has withdrawn the first offer",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "replacement offer is made to claimant",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "claim will be sent for claimant acknowledgement",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_has_withdrawn_the_first_offer()"
});
formatter.result({
  "duration": 35676976200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.replacement_offer_is_made_to_claimant()"
});
formatter.result({
  "duration": 398362987700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 7202895500,
  "status": "passed"
});
formatter.after({
  "duration": 1956214200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 54,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-31;prouser-rejects-the-first-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 55,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "counter offer is sent for revision and SLA is breached",
  "keyword": "Then "
});
formatter.examples({
  "line": 58,
  "name": "",
  "description": "",
  "id": "journey-31;prouser-rejects-the-first-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 59,
      "id": "journey-31;prouser-rejects-the-first-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 60,
      "id": "journey-31;prouser-rejects-the-first-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5669508700,
  "status": "passed"
});
formatter.before({
  "duration": 171400,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-31;prouser-rejects-the-first-offer-to-compensator;;2",
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
  "line": 55,
  "name": "\u0027prouser\u0027 receives the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "counter offer is sent for revision and SLA is breached",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.receives_first_offer(String)"
});
formatter.result({
  "duration": 42809338600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.reject_first_offer(String)"
});
formatter.result({
  "duration": 174606512900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_is_sent_for_revision_sla_breached()"
});
formatter.result({
  "duration": 369774873300,
  "status": "passed"
});
formatter.after({
  "duration": 1771309400,
  "status": "passed"
});
formatter.before({
  "duration": 5516083100,
  "status": "passed"
});
formatter.before({
  "duration": 119600,
  "status": "passed"
});
formatter.scenario({
  "line": 62,
  "name": "Prouser withdraw the offer and replaces with new offer",
  "description": "",
  "id": "journey-31;prouser-withdraw-the-offer-and-replaces-with-new-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 64,
  "name": "Prouser has rejected offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "Prouser withdraw the offer and replace with new offer",
  "keyword": "Then "
});
formatter.step({
  "line": 66,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.compensatoe_doesnot_accept_the_offer_for_more_than_days()"
});
formatter.result({
  "duration": 41352997100,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_withdraw_the_offer_and_replace_with_new_offer()"
});
formatter.result({
  "duration": 151417603800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 12465915700,
  "status": "passed"
});
formatter.after({
  "duration": 1909594900,
  "status": "passed"
});
formatter.before({
  "duration": 6033781900,
  "status": "passed"
});
formatter.before({
  "duration": 108200,
  "status": "passed"
});
formatter.scenario({
  "line": 68,
  "name": "TPA accepts prouser counter offer",
  "description": "",
  "id": "journey-31;tpa-accepts-prouser-counter-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 70,
  "name": "claimant request interm payment to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 71,
  "name": "TPA accepts claimant counter offer",
  "keyword": "When "
});
formatter.step({
  "line": 72,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.request_interim_payment_tpa()"
});
formatter.result({
  "duration": 42700121300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_accepts_counter_offer()"
});
formatter.result({
  "duration": 40615259300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 23414543900,
  "status": "passed"
});
formatter.after({
  "duration": 1703649000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 74,
  "name": "Prouser accepts Fee",
  "description": "",
  "id": "journey-31;prouser-accepts-fee",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 75,
  "name": "prouser review fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 76,
  "name": "\u0027\u003cclaimant\u003e\u0027 accepts revised offer",
  "keyword": "When "
});
formatter.step({
  "line": 77,
  "name": "Acknowledgement will be sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 78,
  "name": "",
  "description": "",
  "id": "journey-31;prouser-accepts-fee;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 79,
      "id": "journey-31;prouser-accepts-fee;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 80,
      "id": "journey-31;prouser-accepts-fee;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5574054200,
  "status": "passed"
});
formatter.before({
  "duration": 60800,
  "status": "passed"
});
formatter.scenario({
  "line": 80,
  "name": "Prouser accepts Fee",
  "description": "",
  "id": "journey-31;prouser-accepts-fee;;2",
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
  "line": 75,
  "name": "prouser review fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 76,
  "name": "\u0027prouser\u0027 accepts revised offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 77,
  "name": "Acknowledgement will be sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_review_fee_proposal()"
});
formatter.result({
  "duration": 40814794400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_accepts_revised_fee_offer(String)"
});
formatter.result({
  "duration": 40965574300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.ack_sent_to_compensator()"
});
formatter.result({
  "duration": 369858647800,
  "status": "passed"
});
formatter.after({
  "duration": 1773928600,
  "status": "passed"
});
formatter.before({
  "duration": 5235995700,
  "status": "passed"
});
formatter.before({
  "duration": 90900,
  "status": "passed"
});
formatter.scenario({
  "line": 82,
  "name": "Claimant goes to court for fees non-payment",
  "description": "",
  "id": "journey-31;claimant-goes-to-court-for-fees-non-payment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 83,
  "name": "SLA is breached for non-payment",
  "keyword": "Given "
});
formatter.step({
  "line": 84,
  "name": "prouser decides to go to court for fee settlement pending",
  "keyword": "When "
});
formatter.step({
  "line": 85,
  "name": "claim sent to compensator for reviewing documents selected",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.sla_breached_non_payment()"
});
formatter.result({
  "duration": 42911011500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_go_to_court_fee_nonpayment_document()"
});
formatter.result({
  "duration": 92517579400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claim_sent_to_compensator_for_review_court_docs()"
});
formatter.result({
  "duration": 12766853500,
  "status": "passed"
});
formatter.after({
  "duration": 1694330400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 87,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-31;tpa-acknowledges-documents-selected-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 88,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 89,
  "name": "TPA agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 90,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 91,
  "name": "",
  "description": "",
  "id": "journey-31;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 92,
      "id": "journey-31;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-FeesListReview"
      ],
      "line": 93,
      "id": "journey-31;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5520660900,
  "status": "passed"
});
formatter.before({
  "duration": 107700,
  "status": "passed"
});
formatter.scenario({
  "line": 93,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-31;tpa-acknowledges-documents-selected-for-court;;2",
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
  "line": 88,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 89,
  "name": "TPA agrees to court documents when claim is in \u0027Pending-FeesListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 90,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_select_court_docs_tpa()"
});
formatter.result({
  "duration": 50705127600,
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
  "duration": 55398412000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 21809051400,
  "status": "passed"
});
formatter.after({
  "duration": 1834410200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 95,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-31;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 96,
  "name": "\u0027\u003cclaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 97,
  "name": "\u0027\u003cclaimant\u003e\u0027 submit the claim for court with claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 98,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 99,
  "name": "",
  "description": "",
  "id": "journey-31;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 100,
      "id": "journey-31;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-FeesListAccept"
      ],
      "line": 101,
      "id": "journey-31;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5619479500,
  "status": "passed"
});
formatter.before({
  "duration": 88300,
  "status": "passed"
});
formatter.scenario({
  "line": 101,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-31;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2",
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
  "line": 96,
  "name": "\u0027prouser\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 97,
  "name": "\u0027prouser\u0027 submit the claim for court with claim \u0027Pending-FeesListAccept\u0027",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 98,
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
  "duration": 83724131000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    },
    {
      "val": "Pending-FeesListAccept",
      "offset": 49
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_submit_claim_to_court(String,String)"
});
formatter.result({
  "duration": 121794617800,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 10382276300,
  "status": "passed"
});
formatter.after({
  "duration": 1656497500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 103,
  "name": "The claim is moved to \u0027Resolved-NonPayment\u0027",
  "description": "",
  "id": "journey-31;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 104,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 105,
  "name": "prouser claim goes to dispute at court at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.examples({
  "line": 107,
  "name": "",
  "description": "",
  "id": "journey-31;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 108,
      "id": "journey-31;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-NonPayment"
      ],
      "line": 109,
      "id": "journey-31;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5621001500,
  "status": "passed"
});
formatter.before({
  "duration": 97500,
  "status": "passed"
});
formatter.scenario({
  "line": 109,
  "name": "The claim is moved to \u0027Resolved-NonPayment\u0027",
  "description": "",
  "id": "journey-31;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;2",
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
  "line": 104,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 105,
  "name": "prouser claim goes to dispute at court at \u0027Resolved-NonPayment\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_goes_to_court(String)"
});
formatter.result({
  "duration": 49387923200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Resolved-NonPayment",
      "offset": 43
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_claim_goes_to_dispute_at_court(String)"
});
formatter.result({
  "duration": 26078047200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 12549695000,
  "status": "passed"
});
formatter.after({
  "duration": 1640100000,
  "status": "passed"
});
});