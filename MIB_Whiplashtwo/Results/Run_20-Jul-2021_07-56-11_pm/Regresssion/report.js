$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/unrep/journey23.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 23",
  "description": "",
  "id": "journey-23",
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
  "name": "Unrep submits claim as owner",
  "description": "",
  "id": "journey-23;unrep-submits-claim-as-owner",
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
  "name": "claimant exits before submitting the claim",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user continues for claim creation as \u0027\u003cowner\u003e\u0027 , \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cct_preference\u003e\u0027 with \u0027\u003cmultivrn\u003e\u0027,\u0027\u003clocation\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "journey-23;unrep-submits-claim-as-owner;",
  "rows": [
    {
      "cells": [
        "owner",
        "involvement_type_v",
        "ct_preference",
        "multivrn",
        "location"
      ],
      "line": 11,
      "id": "journey-23;unrep-submits-claim-as-owner;;1"
    },
    {
      "cells": [
        "YES",
        "I was the driver",
        "EMAIL",
        "NO",
        "Inside UK"
      ],
      "line": 12,
      "id": "journey-23;unrep-submits-claim-as-owner;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9278144900,
  "status": "passed"
});
formatter.before({
  "duration": 111900,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Unrep submits claim as owner",
  "description": "",
  "id": "journey-23;unrep-submits-claim-as-owner;;2",
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
  "name": "claimant exits before submitting the claim",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user continues for claim creation as \u0027YES\u0027 , \u0027I was the driver\u0027 and \u0027EMAIL\u0027 with \u0027NO\u0027,\u0027Inside UK\u0027",
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
  "line": 9,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.user_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 47657240500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_exit_before_submitting_claim()"
});
formatter.result({
  "duration": 11112747000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YES",
      "offset": 38
    },
    {
      "val": "I was the driver",
      "offset": 46
    },
    {
      "val": "EMAIL",
      "offset": 69
    },
    {
      "val": "NO",
      "offset": 82
    },
    {
      "val": "Inside UK",
      "offset": 87
    }
  ],
  "location": "ClaimantActionsStepDefs.user_continues_For_Claim_Creation(String,String,String,String,String)"
});
formatter.result({
  "duration": 548671000000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_Reference_Number_Unrep_Is_Created_Successfully()"
});
formatter.result({
  "duration": 31102138400,
  "status": "passed"
});
formatter.after({
  "duration": 1856029900,
  "status": "passed"
});
formatter.before({
  "duration": 7027204900,
  "status": "passed"
});
formatter.before({
  "duration": 73500,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-23;compensator-receives-claim-and-claim-liability-sent-to-tpa",
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
  "duration": 36752747200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 36094363300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10924791600,
  "status": "passed"
});
formatter.after({
  "duration": 1787843900,
  "status": "passed"
});
formatter.before({
  "duration": 6085988800,
  "status": "passed"
});
formatter.before({
  "duration": 164800,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "TPA  Accepts full liability",
  "description": "",
  "id": "journey-23;tpa--accepts-full-liability",
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
  "name": "TPA accepts full liability",
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
  "duration": 34599217900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 101370524900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 18676783800,
  "status": "passed"
});
formatter.after({
  "duration": 2045682300,
  "status": "passed"
});
formatter.before({
  "duration": 6728141500,
  "status": "passed"
});
formatter.before({
  "duration": 178000,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "unrep Claimant makes medical provider selection (DME) and adds losses and documents",
  "description": "",
  "id": "journey-23;unrep-claimant-makes-medical-provider-selection-(dme)-and-adds-losses-and-documents",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "the unrep claim moves to full liability",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "unrep selects medical preferences for an DME",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "medical preferences are sent to Independent Expert",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_full_liability()"
});
formatter.result({
  "duration": 52400458900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_medical_preference_dme()"
});
formatter.result({
  "duration": 122872367600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.medical_preferences_sent_experts()"
});
formatter.result({
  "duration": 14354702500,
  "status": "passed"
});
formatter.after({
  "duration": 2010639400,
  "status": "passed"
});
formatter.before({
  "duration": 6680452500,
  "status": "passed"
});
formatter.before({
  "duration": 191200,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "DME uploads report-No prognosis",
  "description": "",
  "id": "journey-23;dme-uploads-report-no-prognosis",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "claimant selects DME",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "claimant visits DME and completes checkup",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "DME uploads report no prognosis",
  "keyword": "Then "
});
formatter.match({
  "location": "DMEDefs.claimant_selects_dme()"
});
formatter.result({
  "duration": 50287029100,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.claimant_visits_dme_complete_checkup()"
});
formatter.result({
  "duration": 282477764200,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.dme_upload_report_no_prognosis()"
});
formatter.result({
  "duration": 9833196200,
  "status": "passed"
});
formatter.after({
  "duration": 2179254500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 34,
  "name": "Claimant add losses and fee",
  "description": "",
  "id": "journey-23;claimant-add-losses-and-fee",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 35,
  "name": "DME uploads medical report",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "\u0027\u003cclaimant\u003e\u0027 add losses and fee",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "claim will proceed to upload medical reports",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "journey-23;claimant-add-losses-and-fee;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 39,
      "id": "journey-23;claimant-add-losses-and-fee;;1"
    },
    {
      "cells": [
        "unrep"
      ],
      "line": 40,
      "id": "journey-23;claimant-add-losses-and-fee;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5689552300,
  "status": "passed"
});
formatter.before({
  "duration": 159900,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Claimant add losses and fee",
  "description": "",
  "id": "journey-23;claimant-add-losses-and-fee;;2",
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
  "line": 35,
  "name": "DME uploads medical report",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "\u0027unrep\u0027 add losses and fee",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "claim will proceed to upload medical reports",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.dme_uploads_medical_report()"
});
formatter.result({
  "duration": 49936787400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "unrep",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimants_add_losses_fee(String)"
});
formatter.result({
  "duration": 87265812600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.proceed_to_upload_medical_reports()"
});
formatter.result({
  "duration": 23919538200,
  "status": "passed"
});
formatter.after({
  "duration": 2121725600,
  "status": "passed"
});
formatter.before({
  "duration": 5879850100,
  "status": "passed"
});
formatter.before({
  "duration": 148700,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Claimant decides to proceed with offer",
  "description": "",
  "id": "journey-23;claimant-decides-to-proceed-with-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 44,
  "name": "claimant reviews medical report when uploaded by DME",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "Claimant reviews report and proceed to offer",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "claim will be sent to compensator for review",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.review_medical_report_uploaded_by_dme()"
});
formatter.result({
  "duration": 49497298600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_review_report_and_proceed_to_offer()"
});
formatter.result({
  "duration": 390170274100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_sent_to_compensator_for_review()"
});
formatter.result({
  "duration": 9158918500,
  "status": "passed"
});
formatter.after({
  "duration": 1991470600,
  "status": "passed"
});
formatter.before({
  "duration": 6216988300,
  "status": "passed"
});
formatter.before({
  "duration": 104000,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Claimant should not be able to add losses/fee",
  "description": "",
  "id": "journey-23;claimant-should-not-be-able-to-add-losses/fee",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 49,
  "name": "claimant has proceeded with offer",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "Claimant tries to add loss or fee",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "claimant should not be allowed to add loss/fee",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_has_proceeded_with_offer()"
});
formatter.result({
  "duration": 49346802100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_tries_to_add_loss_or_fee()"
});
formatter.result({
  "duration": 430487436200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_should_not_be_allowd_to_add_loss_fee()"
});
formatter.result({
  "duration": 10103881100,
  "status": "passed"
});
formatter.after({
  "duration": 2149054000,
  "status": "passed"
});
formatter.before({
  "duration": 8066523400,
  "status": "passed"
});
formatter.before({
  "duration": 132600,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "TPA should not be able to add losses/fee",
  "description": "",
  "id": "journey-23;tpa-should-not-be-able-to-add-losses/fee",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "TPA tries to add loss/fee",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "TPA should not be allowed to add loss/fee",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 48060751700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_tries_to_add_loss_fee()"
});
formatter.result({
  "duration": 179273085200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_should_not_be_allowed_to_add_loss_fee()"
});
formatter.result({
  "duration": 9888195900,
  "status": "passed"
});
formatter.after({
  "duration": 1834083500,
  "status": "passed"
});
formatter.before({
  "duration": 7492344600,
  "status": "passed"
});
formatter.before({
  "duration": 134400,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "TPA provides first offer with fee proposal",
  "description": "",
  "id": "journey-23;tpa-provides-first-offer-with-fee-proposal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 59,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 60,
  "name": "the TPA makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "claim will be sent for claimant acknowledgement",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 92321961800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 1364366015500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 11729883400,
  "status": "passed"
});
formatter.after({
  "duration": 2225287100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 63,
  "name": "TPA decides to withdraw the offer",
  "description": "",
  "id": "journey-23;tpa-decides-to-withdraw-the-offer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 64,
  "name": "TPA has made first offer to claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "TPA withdraws the offer at claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.examples({
  "line": 67,
  "name": "",
  "description": "",
  "id": "journey-23;tpa-decides-to-withdraw-the-offer;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 68,
      "id": "journey-23;tpa-decides-to-withdraw-the-offer;;1"
    },
    {
      "cells": [
        "Pending-ReviewOffer"
      ],
      "line": 69,
      "id": "journey-23;tpa-decides-to-withdraw-the-offer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6468966400,
  "status": "passed"
});
formatter.before({
  "duration": 139900,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "TPA decides to withdraw the offer",
  "description": "",
  "id": "journey-23;tpa-decides-to-withdraw-the-offer;;2",
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
  "line": 64,
  "name": "TPA has made first offer to claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "TPA withdraws the offer at claim \u0027Pending-ReviewOffer\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_has_made_first_offer_to_claimant()"
});
formatter.result({
  "duration": 113199273600,
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
  "duration": 47121425400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.stpa_gets_an_option_to_replace_the_offer()"
});
formatter.result({
  "duration": 9830686800,
  "status": "passed"
});
formatter.after({
  "duration": 1878506100,
  "status": "passed"
});
formatter.before({
  "duration": 7390325200,
  "status": "passed"
});
formatter.before({
  "duration": 132400,
  "status": "passed"
});
formatter.scenario({
  "line": 71,
  "name": "TPA makes replacement offer",
  "description": "",
  "id": "journey-23;tpa-makes-replacement-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 72,
  "name": "TPA has withdrawn the first offer",
  "keyword": "Given "
});
formatter.step({
  "line": 73,
  "name": "replacement offer is made to claimant",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "claim offer is sent to claimant review",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_has_withdrawn_the_first_offer()"
});
formatter.result({
  "duration": 67782207500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.replacement_offer_is_made_to_claimant()"
});
formatter.result({
  "duration": 47753135500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_offer_is_sent_to_claimant_review()"
});
formatter.result({
  "duration": 371985688400,
  "status": "passed"
});
formatter.after({
  "duration": 1974421200,
  "status": "passed"
});
formatter.before({
  "duration": 6810579200,
  "status": "passed"
});
formatter.before({
  "duration": 226200,
  "status": "passed"
});
formatter.scenario({
  "line": 76,
  "name": "Claimants accepts final offer from TPA",
  "description": "",
  "id": "journey-23;claimants-accepts-final-offer-from-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 77,
  "name": "TPA has given replacement offer",
  "keyword": "Given "
});
formatter.step({
  "line": 78,
  "name": "Claimant accept the replacement offer",
  "keyword": "When "
});
formatter.step({
  "line": 79,
  "name": "claim is resolved",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.tpa_has_given_replacement_offer()"
});
formatter.result({
  "duration": 106820515900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_accepts_the_final_offer()"
});
formatter.result({
  "duration": 248969610900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_is_resolved()"
});
formatter.result({
  "duration": 14582114100,
  "status": "passed"
});
formatter.after({
  "duration": 2044679700,
  "status": "passed"
});
});