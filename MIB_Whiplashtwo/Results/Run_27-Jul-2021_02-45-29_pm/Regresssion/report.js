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
  "duration": 7636728100,
  "status": "passed"
});
formatter.before({
  "duration": 306700,
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
  "duration": 39289643100,
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
  "duration": 449416662100,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 41831467100,
  "status": "passed"
});
formatter.after({
  "duration": 1903726800,
  "status": "passed"
});
formatter.before({
  "duration": 7555621100,
  "status": "passed"
});
formatter.before({
  "duration": 97800,
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
  "duration": 29539105400,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.csr_assigns_compensator()"
});
formatter.result({
  "duration": 383375313700,
  "status": "passed"
});
formatter.match({
  "location": "CSRStepDefs.claim_sent_to_compensator()"
});
formatter.result({
  "duration": 8912416900,
  "status": "passed"
});
formatter.after({
  "duration": 1695175400,
  "status": "passed"
});
formatter.before({
  "duration": 5357345400,
  "status": "passed"
});
formatter.before({
  "duration": 198100,
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
  "duration": 34111513000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 45609413900,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10517293300,
  "status": "passed"
});
formatter.after({
  "duration": 1644436300,
  "status": "passed"
});
formatter.before({
  "duration": 6194477200,
  "status": "passed"
});
formatter.before({
  "duration": 125700,
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
  "duration": 35531454500,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_claim__denies_claim_liability()"
});
formatter.result({
  "duration": 103970554400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 10348209100,
  "status": "passed"
});
formatter.after({
  "duration": 1682479100,
  "status": "passed"
});
formatter.before({
  "duration": 6359490400,
  "status": "passed"
});
formatter.before({
  "duration": 97800,
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
  "duration": 31657230600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_challenge_decision_go_to_court()"
});
formatter.result({
  "duration": 98900951400,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claimant_goes_to_court()"
});
formatter.result({
  "duration": 11374889700,
  "status": "passed"
});
formatter.after({
  "duration": 1613496300,
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
  "duration": 5970718600,
  "status": "passed"
});
formatter.before({
  "duration": 114300,
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
  "duration": 33488920400,
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
  "duration": 58466446900,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claimant_review_the_documents_uploaded_tpa()"
});
formatter.result({
  "duration": 8545071800,
  "status": "passed"
});
formatter.after({
  "duration": 1630564600,
  "status": "passed"
});
formatter.before({
  "duration": 6601451500,
  "status": "passed"
});
formatter.before({
  "duration": 110000,
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
  "duration": 35418965600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_acknowledge_liability_challenge()"
});
formatter.result({
  "duration": 130242978300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 8542961500,
  "status": "passed"
});
formatter.after({
  "duration": 1690745600,
  "status": "passed"
});
formatter.before({
  "duration": 5786547900,
  "status": "passed"
});
formatter.before({
  "duration": 83400,
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
  "duration": 35729740600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_repoens_liability_disputed_claim()"
});
formatter.result({
  "duration": 79613240600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability_after_reopen()"
});
formatter.result({
  "duration": 10387039900,
  "status": "passed"
});
formatter.after({
  "duration": 1648361800,
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
  "duration": 6559492100,
  "status": "passed"
});
formatter.before({
  "duration": 138600,
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
  "duration": 37157187400,
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
  "duration": 65586390800,
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
  "duration": 148865452300,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 8588150400,
  "status": "passed"
});
formatter.after({
  "duration": 1647041600,
  "status": "passed"
});
formatter.before({
  "duration": 5927836700,
  "status": "passed"
});
formatter.before({
  "duration": 106100,
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
  "duration": 41531853600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_decides_to_proceed_with_offer_during_prognosis_period()"
});
formatter.result({
  "duration": 108842312200,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_sent_claim_for_first_offer()"
});
formatter.result({
  "duration": 12342993000,
  "status": "passed"
});
formatter.after({
  "duration": 1658018500,
  "status": "passed"
});
formatter.before({
  "duration": 6190908000,
  "status": "passed"
});
formatter.before({
  "duration": 101600,
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
  "duration": 32715456700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_first_offer_fee_proposal()"
});
formatter.result({
  "duration": 192723257600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_for_claimant_ack()"
});
formatter.result({
  "duration": 8504850000,
  "status": "passed"
});
formatter.after({
  "duration": 1660310600,
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
  "duration": 4771765300,
  "status": "passed"
});
formatter.before({
  "duration": 87300,
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
  "duration": 31440932100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.prouser_accepts_offer()"
});
formatter.result({
  "duration": 77874146800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.acknowledgement_for_offer_acceptance_will_be_sent_to_compensator()"
});
formatter.result({
  "duration": 11205008000,
  "status": "passed"
});
formatter.after({
  "duration": 1662063600,
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
  "duration": 5014686300,
  "status": "passed"
});
formatter.before({
  "duration": 61200,
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
  "duration": 32433825300,
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
  "duration": 37719589400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sla_breached()"
});
formatter.result({
  "duration": 368189756000,
  "status": "passed"
});
formatter.after({
  "duration": 1607940600,
  "status": "passed"
});
formatter.before({
  "duration": 5872220200,
  "status": "passed"
});
formatter.before({
  "duration": 103300,
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
  "duration": 44464452200,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_go_to_court_select_court_document()"
});
formatter.result({
  "duration": 1061987653800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.documents_will_be_sent_tpa()"
});
formatter.result({
  "duration": 11699505500,
  "status": "passed"
});
formatter.after({
  "duration": 1657758700,
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
  "duration": 4980848900,
  "status": "passed"
});
formatter.before({
  "duration": 108800,
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
  "duration": 41233338400,
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
  "duration": 54614466700,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 20773359900,
  "status": "passed"
});
formatter.after({
  "duration": 1606099800,
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
        "Pending-OfferListAccept"
      ],
      "line": 108,
      "id": "journey-10;claimant-checks-the-documents-selected-by-compensator-and-proceeds-the-claim-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5699580500,
  "status": "passed"
});
formatter.before({
  "duration": 7252300,
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
  "name": "\u0027prouser\u0027 submit the claim for court with claim \u0027Pending-OfferListAccept\u0027",
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
  "duration": 37896846700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    },
    {
      "val": "Pending-OfferListAccept",
      "offset": 49
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_submit_claim_to_court(String,String)"
});
formatter.result({
  "duration": 110888012300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.go_to_court_claim_closed()"
});
formatter.result({
  "duration": 11735268900,
  "status": "passed"
});
formatter.after({
  "duration": 1906911500,
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
  "duration": 6752605300,
  "status": "passed"
});
formatter.before({
  "duration": 199000,
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
  "duration": 39570927100,
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
  "duration": 26338771600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 12133818900,
  "status": "passed"
});
formatter.after({
  "duration": 1834862100,
  "status": "passed"
});
});