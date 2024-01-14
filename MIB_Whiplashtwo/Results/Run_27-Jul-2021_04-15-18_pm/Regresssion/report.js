$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey20.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 20",
  "description": "",
  "id": "journey-20",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-20;prouser-submit-a-claim-as-passenger-in-bus",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "prouser enter all mandatory details for claim creation as \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cowner\u003e\u0027 and \u0027\u003cmultivrn\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "journey-20;prouser-submit-a-claim-as-passenger-in-bus;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 12,
      "id": "journey-20;prouser-submit-a-claim-as-passenger-in-bus;;1"
    },
    {
      "cells": [
        "A passenger on a bus",
        "NO",
        "NO"
      ],
      "line": 13,
      "id": "journey-20;prouser-submit-a-claim-as-passenger-in-bus;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 10680038800,
  "status": "passed"
});
formatter.before({
  "duration": 316700,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-20;prouser-submit-a-claim-as-passenger-in-bus;;2",
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
  "line": 7,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "prouser enter all mandatory details for claim creation as \u0027A passenger on a bus\u0027 and \u0027NO\u0027 and \u0027NO\u0027",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 46425836100,
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
  "duration": 474206279000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 44957562100,
  "status": "passed"
});
formatter.after({
  "duration": 1973624300,
  "status": "passed"
});
formatter.before({
  "duration": 6758544000,
  "status": "passed"
});
formatter.before({
  "duration": 1202000,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-20;compensator-receives-claim-and-claim-liability-sent-to-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "compensator receives claim and send to TPA",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "claims acceptance and liability decision is now sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 38099412300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 35848931100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 12432182100,
  "status": "passed"
});
formatter.after({
  "duration": 1828710900,
  "status": "passed"
});
formatter.before({
  "duration": 7002326800,
  "status": "passed"
});
formatter.before({
  "duration": 213800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "TPA disputes causation and admits part liability",
  "description": "",
  "id": "journey-20;tpa-disputes-causation-and-admits-part-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "TPA accepts claim and makes part liability with dispute",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 44937090900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_part_liability_without_dispute()"
});
formatter.result({
  "duration": 119071114600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 12062937500,
  "status": "passed"
});
formatter.after({
  "duration": 1995275900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-20;prouser-uploads-medical-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "upload medical report is enabled for \u0027\u003cclaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "\u0027\u003cclaimant\u003e\u0027 adds fee",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "claimant uploads medical report at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 32,
  "name": "",
  "description": "",
  "id": "journey-20;prouser-uploads-medical-report;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 33,
      "id": "journey-20;prouser-uploads-medical-report;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-MedPartCausation"
      ],
      "line": 34,
      "id": "journey-20;prouser-uploads-medical-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7086560000,
  "status": "passed"
});
formatter.before({
  "duration": 140600,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Prouser uploads medical report",
  "description": "",
  "id": "journey-20;prouser-uploads-medical-report;;2",
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
  "line": 27,
  "name": "upload medical report is enabled for \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "\u0027prouser\u0027 adds fee",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "claimant uploads medical report at \u0027Pending-MedPartCausation\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
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
  "duration": 39662540600,
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
  "duration": 67385206000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-MedPartCausation",
      "offset": 36
    }
  ],
  "location": "ProUserActionsStepDefs.medical_report_prouser(String)"
});
formatter.result({
  "duration": 203827770100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 12252893500,
  "status": "passed"
});
formatter.after({
  "duration": 2023021600,
  "status": "passed"
});
formatter.before({
  "duration": 6715988600,
  "status": "passed"
});
formatter.before({
  "duration": 142200,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "TPA makes First Offer with fee proposal",
  "description": "",
  "id": "journey-20;tpa-makes-first-offer-with-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "the TPA makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "claim will be sent for claimant acknowledgement",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 41441565900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 200203509300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 9442334900,
  "status": "passed"
});
formatter.after({
  "duration": 1892866900,
  "status": "passed"
});
formatter.before({
  "duration": 7213654300,
  "status": "passed"
});
formatter.before({
  "duration": 178400,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "prouser accepts offer and rejects fee proposal",
  "description": "",
  "id": "journey-20;prouser-accepts-offer-and-rejects-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "prouser review fee proposal",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "prouser accepts offer and makes counter fees proposal",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "pro counter offer sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_review_fee_proposal()"
});
formatter.result({
  "duration": 37837800300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_accepts_offer_reject_fees_proposal()"
});
formatter.result({
  "duration": 104569012000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_counter_offer_sent_compensator()"
});
formatter.result({
  "duration": 368426867600,
  "status": "passed"
});
formatter.after({
  "duration": 1936613901,
  "status": "passed"
});
formatter.before({
  "duration": 6368994500,
  "status": "passed"
});
formatter.before({
  "duration": 142801,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "TPA doesnot respond to the counter fee proposal and claimant goes to court",
  "description": "",
  "id": "journey-20;tpa-doesnot-respond-to-the-counter-fee-proposal-and-claimant-goes-to-court",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 47,
  "name": "TPA doesnot respond to the claimant counter offer request",
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "prouser claimant goes to court over fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "claim will be sent to compensator to review nvc answers",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.compensator_does_not_respond_to_the_counter_offer()"
});
formatter.result({
  "duration": 39625181099,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_goes_to_court_for_fee_proposal()"
});
formatter.result({
  "duration": 105348030201,
  "status": "passed"
});
formatter.match({
  "location": "MIBProActionsStepDefs.mibprouser_claim_sent_to_compensator_for_review_nvc_answers_mibprouser()"
});
formatter.result({
  "duration": 12148680901,
  "status": "passed"
});
formatter.after({
  "duration": 2382451199,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 51,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-20;tpa-acknowledges-documents-selected-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 52,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "TPA agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 55,
  "name": "",
  "description": "",
  "id": "journey-20;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 56,
      "id": "journey-20;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-FeesListReview"
      ],
      "line": 57,
      "id": "journey-20;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7272449800,
  "status": "passed"
});
formatter.before({
  "duration": 228501,
  "status": "passed"
});
formatter.scenario({
  "line": 57,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-20;tpa-acknowledges-documents-selected-for-court;;2",
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
  "line": 52,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "TPA agrees to court documents when claim is in \u0027Pending-FeesListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_select_court_docs_tpa()"
});
formatter.result({
  "duration": 39698447100,
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
  "duration": 55687825501,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20923094900,
  "status": "passed"
});
formatter.after({
  "duration": 1889046500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 59,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-20;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 60,
  "name": "\u0027\u003cclaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "\u0027\u003cclaimant\u003e\u0027 submit the claim for court with claim \u0027\u003cstatus\u003e\u0027 for fee dispute",
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 63,
  "name": "",
  "description": "",
  "id": "journey-20;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 64,
      "id": "journey-20;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-FeesListAccept"
      ],
      "line": 65,
      "id": "journey-20;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6090748299,
  "status": "passed"
});
formatter.before({
  "duration": 128500,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "prouser Claimant acknowledges Compensators doc selection and case is resolved",
  "description": "",
  "id": "journey-20;prouser-claimant-acknowledges-compensators-doc-selection-and-case-is-resolved;;2",
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
  "line": 60,
  "name": "\u0027prouser\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "\u0027prouser\u0027 submit the claim for court with claim \u0027Pending-FeesListAccept\u0027 for fee dispute",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 62,
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
  "duration": 38060060801,
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
  "location": "ClaimantActionsStepDefs.claimant_submit_claim_to_court_fee_dispute(String,String)"
});
formatter.result({
  "duration": 181106075000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 9212379100,
  "status": "passed"
});
formatter.after({
  "duration": 1904199800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 67,
  "name": "The claim is moved to \u0027Resolved-CourtFees\u0027",
  "description": "",
  "id": "journey-20;the-claim-is-moved-to-\u0027resolved-courtfees\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 68,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "prouser claim goes to dispute at court at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.examples({
  "line": 71,
  "name": "",
  "description": "",
  "id": "journey-20;the-claim-is-moved-to-\u0027resolved-courtfees\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 72,
      "id": "journey-20;the-claim-is-moved-to-\u0027resolved-courtfees\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-CourtFees"
      ],
      "line": 73,
      "id": "journey-20;the-claim-is-moved-to-\u0027resolved-courtfees\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6912626100,
  "status": "passed"
});
formatter.before({
  "duration": 114001,
  "status": "passed"
});
formatter.scenario({
  "line": 73,
  "name": "The claim is moved to \u0027Resolved-CourtFees\u0027",
  "description": "",
  "id": "journey-20;the-claim-is-moved-to-\u0027resolved-courtfees\u0027;;2",
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
  "line": 68,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "prouser claim goes to dispute at court at \u0027Resolved-CourtFees\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 70,
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
  "duration": 39908387600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Resolved-CourtFees",
      "offset": 43
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_claim_goes_to_dispute_at_court(String)"
});
formatter.result({
  "duration": 26084123200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 12162931999,
  "status": "passed"
});
formatter.after({
  "duration": 2019454100,
  "status": "passed"
});
});