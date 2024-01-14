$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey10.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 10",
  "description": "",
  "id": "journey-10",
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
  "name": "Prouser Submit a Claim as passenger in a car",
  "description": "",
  "id": "journey-10;prouser-submit-a-claim-as-passenger-in-a-car",
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
  "id": "journey-10;prouser-submit-a-claim-as-passenger-in-a-car;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 10,
      "id": "journey-10;prouser-submit-a-claim-as-passenger-in-a-car;;1"
    },
    {
      "cells": [
        "A passenger in a car/van/lorry",
        "NO",
        "YES"
      ],
      "line": 11,
      "id": "journey-10;prouser-submit-a-claim-as-passenger-in-a-car;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8576027100,
  "status": "passed"
});
formatter.before({
  "duration": 383700,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Prouser Submit a Claim as passenger in a car",
  "description": "",
  "id": "journey-10;prouser-submit-a-claim-as-passenger-in-a-car;;2",
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
  "name": "prouser enter all mandatory details for claim creation as \u0027A passenger in a car/van/lorry\u0027 and \u0027NO\u0027 and \u0027YES\u0027",
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
  "duration": 46854821900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A passenger in a car/van/lorry",
      "offset": 59
    },
    {
      "val": "NO",
      "offset": 96
    },
    {
      "val": "YES",
      "offset": 105
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String)"
});
formatter.result({
  "duration": 471785786600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 45837896900,
  "status": "passed"
});
formatter.after({
  "duration": 1887847200,
  "status": "passed"
});
formatter.before({
  "duration": 6209668600,
  "status": "passed"
});
formatter.before({
  "duration": 96500,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "CSR allocates claim to  compensator",
  "description": "",
  "id": "journey-10;csr-allocates-claim-to--compensator",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Claim received by csr and eligible for assigning to compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "CSR assigns compensator",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Claim is sent to respective compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "CSRStepDefs.claim_received_by_csr()"
});
formatter.result({
  "duration": 41612956700,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.csr_assigns_compensator()"
});
formatter.result({
  "duration": 89819009900,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.claim_sent_to_compensator()"
});
formatter.result({
  "duration": 11353114600,
  "status": "passed"
});
formatter.after({
  "duration": 1858804500,
  "status": "passed"
});
formatter.before({
  "duration": 6659558900,
  "status": "passed"
});
formatter.before({
  "duration": 106400,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-10;compensator-receives-claim-and-claim-liability-sent-to-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "compensator receives claim and send to TPA",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "claims acceptance and liability decision is now sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 39319118100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 48484096600,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 11364447500,
  "status": "passed"
});
formatter.after({
  "duration": 1708432700,
  "status": "passed"
});
formatter.before({
  "duration": 5816496700,
  "status": "passed"
});
formatter.before({
  "duration": 114100,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "TPA dispute denies liability",
  "description": "",
  "id": "journey-10;tpa-dispute-denies-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "the claim  has been sent to the TPA workbasket",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "TPA dispute claim liability",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claim_has_been_sent_to_TPA()"
});
formatter.result({
  "duration": 46086598500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_claim__denies_claim_liability()"
});
formatter.result({
  "duration": 119786000900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 11820429500,
  "status": "passed"
});
formatter.after({
  "duration": 1923440900,
  "status": "passed"
});
formatter.before({
  "duration": 6484876800,
  "status": "passed"
});
formatter.before({
  "duration": 177900,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Prouser challenge decision and go to court and submit documents",
  "description": "",
  "id": "journey-10;prouser-challenge-decision-and-go-to-court-and-submit-documents",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "Prouser claim liability has been rejected",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "prouser wants to challenge decision and decided to go to court",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "the claimant goes to court",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_claim_liability_rejected()"
});
formatter.result({
  "duration": 45042838900,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_challenge_decision_go_to_court()"
});
formatter.result({
  "duration": 102168421200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claimant_goes_to_court()"
});
formatter.result({
  "duration": 12751500500,
  "status": "passed"
});
formatter.after({
  "duration": 1871107900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 35,
  "name": "TPA disagree for document selection",
  "description": "",
  "id": "journey-10;tpa-disagree-for-document-selection",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 36,
  "name": "Uploaded documents for court cofirmed by Claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "TPA disagrees to court documents uploaded by Claimant at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "claimant need to review the documents uploaded by TPA",
  "keyword": "Then "
});
formatter.examples({
  "line": 39,
  "name": "",
  "description": "",
  "id": "journey-10;tpa-disagree-for-document-selection;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 40,
      "id": "journey-10;tpa-disagree-for-document-selection;;1"
    },
    {
      "cells": [
        "Pending-LiabilityListReview"
      ],
      "line": 41,
      "id": "journey-10;tpa-disagree-for-document-selection;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5832936800,
  "status": "passed"
});
formatter.before({
  "duration": 156600,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "TPA disagree for document selection",
  "description": "",
  "id": "journey-10;tpa-disagree-for-document-selection;;2",
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
  "line": 36,
  "name": "Uploaded documents for court cofirmed by Claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "TPA disagrees to court documents uploaded by Claimant at \u0027Pending-LiabilityListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "claimant need to review the documents uploaded by TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.court_documents_confirmed_claimant()"
});
formatter.result({
  "duration": 37525189700,
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
  "duration": 59796585200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claimant_review_the_documents_uploaded_tpa()"
});
formatter.result({
  "duration": 9692938800,
  "status": "passed"
});
formatter.after({
  "duration": 1908817000,
  "status": "passed"
});
formatter.before({
  "duration": 5460774200,
  "status": "passed"
});
formatter.before({
  "duration": 121800,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-10;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 44,
  "name": "prouser receives claim for acknowledgement",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "prouser claimant acknowledge for liability challenge",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_receives_the_claim_for_acknowledgement()"
});
formatter.result({
  "duration": 43415444400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_acknowledge_liability_challenge()"
});
formatter.result({
  "duration": 132092426800,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 9520842700,
  "status": "passed"
});
formatter.after({
  "duration": 1756917100,
  "status": "passed"
});
formatter.before({
  "duration": 6867842400,
  "status": "passed"
});
formatter.before({
  "duration": 129400,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "TPA reopens claim and make full liability to claimant",
  "description": "",
  "id": "journey-10;tpa-reopens-claim-and-make-full-liability-to-claimant",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 49,
  "name": "Claim is resolved at court",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "TPA reopens liability disputed claim",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "TPA accepts full liability after reopening the claim",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_uploads_court_documents()"
});
formatter.result({
  "duration": 35309336000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_repoens_liability_disputed_claim()"
});
formatter.result({
  "duration": 79555138800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability_after_reopen()"
});
formatter.result({
  "duration": 12330870600,
  "status": "passed"
});
formatter.after({
  "duration": 1718598000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 53,
  "name": "Prouser  uploads medical Report with waitout prognosis and decides waitout and release report to TPA",
  "description": "",
  "id": "journey-10;prouser--uploads-medical-report-with-waitout-prognosis-and-decides-waitout-and-release-report-to-tpa",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 54,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives claim",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "\u0027\u003cclaimant\u003e\u0027 adds fee",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "prouser uploads the medical report with waitout prognosis \u0027\u003cstatus\u003e\u0027 and decides to waitout",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 59,
  "name": "",
  "description": "",
  "id": "journey-10;prouser--uploads-medical-report-with-waitout-prognosis-and-decides-waitout-and-release-report-to-tpa;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 60,
      "id": "journey-10;prouser--uploads-medical-report-with-waitout-prognosis-and-decides-waitout-and-release-report-to-tpa;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-MedicalAfterCourt"
      ],
      "line": 61,
      "id": "journey-10;prouser--uploads-medical-report-with-waitout-prognosis-and-decides-waitout-and-release-report-to-tpa;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6370561500,
  "status": "passed"
});
formatter.before({
  "duration": 104600,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "Prouser  uploads medical Report with waitout prognosis and decides waitout and release report to TPA",
  "description": "",
  "id": "journey-10;prouser--uploads-medical-report-with-waitout-prognosis-and-decides-waitout-and-release-report-to-tpa;;2",
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
  "line": 54,
  "name": "\u0027prouser\u0027 receives claim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "\u0027prouser\u0027 adds fee",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "prouser uploads the medical report with waitout prognosis \u0027Pending-MedicalAfterCourt\u0027 and decides to waitout",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.user_Receives_Claim(String)"
});
formatter.result({
  "duration": 40060943600,
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
  "duration": 66356998900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-MedicalAfterCourt",
      "offset": 59
    }
  ],
  "location": "ProUserActionsStepDefs.claimant_upload_medical_report(String)"
});
formatter.result({
  "duration": 151888584000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 9195529600,
  "status": "passed"
});
formatter.after({
  "duration": 1732208300,
  "status": "passed"
});
formatter.before({
  "duration": 6133196000,
  "status": "passed"
});
formatter.before({
  "duration": 98300,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Prouser decides to proceed with offer",
  "description": "",
  "id": "journey-10;prouser-decides-to-proceed-with-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 64,
  "name": "claimant is in prognosis period",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "claimant decides to proceed with offer during prognosis period",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "claim will be sent to TPA for offer",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_is_in_prognosis_period()"
});
formatter.result({
  "duration": 48539492200,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_decides_to_proceed_with_offer_during_prognosis_period()"
});
formatter.result({
  "duration": 426046385600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_sent_claim_for_first_offer()"
});
formatter.result({
  "duration": 10171349900,
  "status": "passed"
});
formatter.after({
  "duration": 1618911700,
  "status": "passed"
});
formatter.before({
  "duration": 5831652600,
  "status": "passed"
});
formatter.before({
  "duration": 67000,
  "status": "passed"
});
formatter.scenario({
  "line": 68,
  "name": "TPA First Offer to Prouser",
  "description": "",
  "id": "journey-10;tpa-first-offer-to-prouser",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 69,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "the TPA makes first offer with fee proposal",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "claim will be sent for claimant acknowledgement",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 36640556400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 193771715600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 8885128300,
  "status": "passed"
});
formatter.after({
  "duration": 1718386400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 73,
  "name": "Claimant Accepts First Offer to TPA",
  "description": "",
  "id": "journey-10;claimant-accepts-first-offer-to-tpa",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 74,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "Prousuer accepts offer",
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "Acknowledgement for offer acceptance will be sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 77,
  "name": "",
  "description": "",
  "id": "journey-10;claimant-accepts-first-offer-to-tpa;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 78,
      "id": "journey-10;claimant-accepts-first-offer-to-tpa;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 79,
      "id": "journey-10;claimant-accepts-first-offer-to-tpa;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6315206400,
  "status": "passed"
});
formatter.before({
  "duration": 98800,
  "status": "passed"
});
formatter.scenario({
  "line": 79,
  "name": "Claimant Accepts First Offer to TPA",
  "description": "",
  "id": "journey-10;claimant-accepts-first-offer-to-tpa;;2",
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
  "line": 74,
  "name": "\u0027prouser\u0027 receives the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "Prousuer accepts offer",
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "Acknowledgement for offer acceptance will be sent to compensator",
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
  "duration": 35421988000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.prouser_accepts_offer()"
});
formatter.result({
  "duration": 78143891800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.acknowledgement_for_offer_acceptance_will_be_sent_to_compensator()"
});
formatter.result({
  "duration": 12445377400,
  "status": "passed"
});
formatter.after({
  "duration": 1730076600,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 81,
  "name": "TPA acknowledge claimant offer",
  "description": "",
  "id": "journey-10;tpa-acknowledge-claimant-offer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 82,
  "name": "claimant accepts the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 83,
  "name": "TPA acknowledges claimants offer with claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "claim SLA is breached",
  "keyword": "Then "
});
formatter.examples({
  "line": 85,
  "name": "",
  "description": "",
  "id": "journey-10;tpa-acknowledge-claimant-offer;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 86,
      "id": "journey-10;tpa-acknowledge-claimant-offer;;1"
    },
    {
      "cells": [
        "Pending-Acknowledgement"
      ],
      "line": 87,
      "id": "journey-10;tpa-acknowledge-claimant-offer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5995124100,
  "status": "passed"
});
formatter.before({
  "duration": 61000,
  "status": "passed"
});
formatter.scenario({
  "line": 87,
  "name": "TPA acknowledge claimant offer",
  "description": "",
  "id": "journey-10;tpa-acknowledge-claimant-offer;;2",
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
  "line": 82,
  "name": "claimant accepts the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 83,
  "name": "TPA acknowledges claimants offer with claim \u0027Pending-Acknowledgement\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "claim SLA is breached",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_accepts_the_offer_from_tpa()"
});
formatter.result({
  "duration": 33567309600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-Acknowledgement",
      "offset": 45
    }
  ],
  "location": "TPAStepDefs.TPA_acknowledges_claimants_offer(String)"
});
formatter.result({
  "duration": 38960617200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sla_breached()"
});
formatter.result({
  "duration": 368990983000,
  "status": "passed"
});
formatter.after({
  "duration": 1667306100,
  "status": "passed"
});
formatter.before({
  "duration": 4928325300,
  "status": "passed"
});
formatter.before({
  "duration": 58200,
  "status": "passed"
});
formatter.scenario({
  "line": 89,
  "name": "Claimant decides to go to court (OCS3)",
  "description": "",
  "id": "journey-10;claimant-decides-to-go-to-court-(ocs3)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 90,
  "name": "SLA is breached for non-payment",
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "prouser decides to go to court for claim settlement pending",
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "documents will be sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.sla_breached_non_payment()"
});
formatter.result({
  "duration": 39587016400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_go_to_court_select_court_document()"
});
formatter.result({
  "duration": 1897362248100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.documents_will_be_sent_tpa()"
});
formatter.result({
  "duration": 12617667200,
  "status": "passed"
});
formatter.after({
  "duration": 1744339800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 94,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-10;tpa-acknowledges-documents-selected-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 95,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 96,
  "name": "TPA agrees to court documents when claim is in \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.examples({
  "line": 98,
  "name": "",
  "description": "",
  "id": "journey-10;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 99,
      "id": "journey-10;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-OfferListReview"
      ],
      "line": 100,
      "id": "journey-10;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5194614300,
  "status": "passed"
});
formatter.before({
  "duration": 141600,
  "status": "passed"
});
formatter.scenario({
  "line": 100,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-10;tpa-acknowledges-documents-selected-for-court;;2",
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
  "line": 95,
  "name": "claimant selects court documents TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 96,
  "name": "TPA agrees to court documents when claim is in \u0027Pending-OfferListReview\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_select_court_docs_tpa()"
});
formatter.result({
  "duration": 34009316900,
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
  "duration": 53708849700,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20736818800,
  "status": "passed"
});
formatter.after({
  "duration": 1595866800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 102,
  "name": "Claimant checks the documents selected by Compensator and proceeds the claim for court",
  "description": "",
  "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 103,
  "name": "\u0027\u003cclaimant\u003e\u0027 checks the documents uploaded by Compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 104,
  "name": "\u0027\u003cclaimant\u003e\u0027 submit the claim for court with claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 105,
  "name": "Case is closed with Go to court at offer stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 106,
  "name": "",
  "description": "",
  "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 107,
      "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-OfferFeesListAccept"
      ],
      "line": 108,
      "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5090697200,
  "status": "passed"
});
formatter.before({
  "duration": 10471100,
  "status": "passed"
});
formatter.scenario({
  "line": 108,
  "name": "Claimant checks the documents selected by Compensator and proceeds the claim for court",
  "description": "",
  "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court;;2",
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
  "line": 103,
  "name": "\u0027prouser\u0027 checks the documents uploaded by Compensator",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 104,
  "name": "\u0027prouser\u0027 submit the claim for court with claim \u0027Pending-OfferFeesListAccept\u0027",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 105,
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
  "duration": 37283923300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    },
    {
      "val": "Pending-OfferFeesListAccept",
      "offset": 49
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_submit_claim_to_court(String,String)"
});
formatter.result({
  "duration": 108798848500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.go_to_court_claim_closed()"
});
formatter.result({
  "duration": 11739653800,
  "status": "passed"
});
formatter.after({
  "duration": 1706766900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 110,
  "name": "The claim is moved to \u0027Resolved-NonPayment\u0027",
  "description": "",
  "id": "journey-10;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 111,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 112,
  "name": "prouser claim goes to dispute at court at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 113,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.examples({
  "line": 114,
  "name": "",
  "description": "",
  "id": "journey-10;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 115,
      "id": "journey-10;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-NonPayment"
      ],
      "line": 116,
      "id": "journey-10;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6086965100,
  "status": "passed"
});
formatter.before({
  "duration": 62400,
  "status": "passed"
});
formatter.scenario({
  "line": 116,
  "name": "The claim is moved to \u0027Resolved-NonPayment\u0027",
  "description": "",
  "id": "journey-10;the-claim-is-moved-to-\u0027resolved-nonpayment\u0027;;2",
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
  "line": 111,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 112,
  "name": "prouser claim goes to dispute at court at \u0027Resolved-NonPayment\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 113,
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
  "duration": 35022327600,
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
  "duration": 25783338200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 11806592300,
  "status": "passed"
});
formatter.after({
  "duration": 1677987200,
  "status": "passed"
});
});