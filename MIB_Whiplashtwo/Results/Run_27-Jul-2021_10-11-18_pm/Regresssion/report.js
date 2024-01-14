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
  "duration": 8554486800,
  "status": "passed"
});
formatter.before({
  "duration": 193900,
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
  "duration": 50960932200,
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
  "duration": 450708465300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 42061302800,
  "status": "passed"
});
formatter.after({
  "duration": 1792729100,
  "status": "passed"
});
formatter.before({
  "duration": 5290024600,
  "status": "passed"
});
formatter.before({
  "duration": 74000,
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
  "duration": 39100462000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 35563376800,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10100916600,
  "status": "passed"
});
formatter.after({
  "duration": 1664897700,
  "status": "passed"
});
formatter.before({
  "duration": 5834197600,
  "status": "passed"
});
formatter.before({
  "duration": 99000,
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
  "duration": 35313887900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 94738232900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 11613783200,
  "status": "passed"
});
formatter.after({
  "duration": 1703150300,
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
  "duration": 5579257800,
  "status": "passed"
});
formatter.before({
  "duration": 224400,
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
  "duration": 43607861400,
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
  "duration": 67152606700,
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
  "duration": 197240018800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 12058418800,
  "status": "passed"
});
formatter.after({
  "duration": 1805151300,
  "status": "passed"
});
formatter.before({
  "duration": 5426965600,
  "status": "passed"
});
formatter.before({
  "duration": 100100,
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
  "duration": 37874470300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 199796629700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_offer_is_sent_to_claimant_review()"
});
formatter.result({
  "duration": 367842036600,
  "status": "passed"
});
formatter.after({
  "duration": 1677252700,
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
  "duration": 5196200400,
  "status": "passed"
});
formatter.before({
  "duration": 56200,
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
  "duration": 38471708700,
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
  "duration": 42279992800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.stpa_gets_an_option_to_replace_the_offer()"
});
formatter.result({
  "duration": 9134845200,
  "status": "passed"
});
formatter.after({
  "duration": 1640116700,
  "status": "passed"
});
formatter.before({
  "duration": 5028834200,
  "status": "passed"
});
formatter.before({
  "duration": 81600,
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
  "duration": 38553995500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.replacement_offer_is_made_to_claimant()"
});
formatter.result({
  "duration": 40158934700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 8852394900,
  "status": "passed"
});
formatter.after({
  "duration": 1679565500,
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
  "duration": 4996748900,
  "status": "passed"
});
formatter.before({
  "duration": 99400,
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
  "duration": 38543859500,
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
  "duration": 169238540900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_is_sent_for_revision_sla_breached()"
});
formatter.result({
  "duration": 370179190400,
  "status": "passed"
});
formatter.after({
  "duration": 1692873600,
  "status": "passed"
});
formatter.before({
  "duration": 5099114300,
  "status": "passed"
});
formatter.before({
  "duration": 82100,
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
  "duration": 36465123200,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_withdraw_the_offer_and_replace_with_new_offer()"
});
formatter.result({
  "duration": 142561021400,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11505045000,
  "status": "passed"
});
formatter.after({
  "duration": 1668581700,
  "status": "passed"
});
formatter.before({
  "duration": 4693127900,
  "status": "passed"
});
formatter.before({
  "duration": 331200,
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
  "duration": 40335539500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_accepts_counter_offer()"
});
formatter.result({
  "duration": 40262010500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20579785900,
  "status": "passed"
});
formatter.after({
  "duration": 1766437800,
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
  "duration": 5682285300,
  "status": "passed"
});
formatter.before({
  "duration": 124100,
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
  "duration": 40851069000,
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
  "duration": 41426615100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.ack_sent_to_compensator()"
});
formatter.result({
  "duration": 369044866500,
  "status": "passed"
});
formatter.after({
  "duration": 1956693100,
  "status": "passed"
});
formatter.before({
  "duration": 5461926000,
  "status": "passed"
});
formatter.before({
  "duration": 49200,
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
  "duration": 40277309800,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_go_to_court_fee_nonpayment_document()"
});
formatter.result({
  "duration": 81800302800,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claim_sent_to_compensator_for_review_court_docs()"
});
formatter.result({
  "duration": 11519627700,
  "status": "passed"
});
formatter.after({
  "duration": 1743744400,
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
  "duration": 5647733900,
  "status": "passed"
});
formatter.before({
  "duration": 55600,
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
  "duration": 40499109900,
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
  "duration": 52586342600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20452522800,
  "status": "passed"
});
formatter.after({
  "duration": 1686103700,
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
  "duration": 4712383100,
  "status": "passed"
});
formatter.before({
  "duration": 86000,
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
  "duration": 43155629100,
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
  "duration": 110164183600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 8347502100,
  "status": "passed"
});
formatter.after({
  "duration": 1877180600,
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
  "duration": 6183527900,
  "status": "passed"
});
formatter.before({
  "duration": 72000,
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
  "duration": 40443351500,
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
  "duration": 25670668700,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 11497980000,
  "status": "passed"
});
formatter.after({
  "duration": 1684511000,
  "status": "passed"
});
});