$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/unrep/journey18.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 18",
  "description": "",
  "id": "journey-18",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@unrep"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Unrep claim creation as car owner",
  "description": "",
  "id": "journey-18;unrep-claim-creation-as-car-owner",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "unrep logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enter all mandatory details for claim creation as \u0027\u003cowner\u003e\u0027 , \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cct_preference\u003e\u0027 with \u0027\u003cmultivrn\u003e\u0027,\u0027\u003clocation\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "journey-18;unrep-claim-creation-as-car-owner;",
  "rows": [
    {
      "cells": [
        "owner",
        "involvement_type_v",
        "ct_preference",
        "multivrn",
        "location"
      ],
      "line": 9,
      "id": "journey-18;unrep-claim-creation-as-car-owner;;1"
    },
    {
      "cells": [
        "NO",
        "I was the driver",
        "BOTH",
        "NO",
        "Inside UK"
      ],
      "line": 10,
      "id": "journey-18;unrep-claim-creation-as-car-owner;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7606122400,
  "status": "passed"
});
formatter.before({
  "duration": 221900,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Unrep claim creation as car owner",
  "description": "",
  "id": "journey-18;unrep-claim-creation-as-car-owner;;2",
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
  "line": 5,
  "name": "unrep logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enter all mandatory details for claim creation as \u0027NO\u0027 , \u0027I was the driver\u0027 and \u0027BOTH\u0027 with \u0027NO\u0027,\u0027Inside UK\u0027",
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
  "line": 7,
  "name": "claim reference number for unrep claim is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.user_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 44195262400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "NO",
      "offset": 56
    },
    {
      "val": "I was the driver",
      "offset": 63
    },
    {
      "val": "BOTH",
      "offset": 86
    },
    {
      "val": "NO",
      "offset": 98
    },
    {
      "val": "Inside UK",
      "offset": 103
    }
  ],
  "location": "ClaimantActionsStepDefs.user_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String,String,String)"
});
formatter.result({
  "duration": 453023962000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_Reference_Number_Unrep_Is_Created_Successfully()"
});
formatter.result({
  "duration": 31070253900,
  "status": "passed"
});
formatter.after({
  "duration": 1761163000,
  "status": "passed"
});
formatter.before({
  "duration": 5678083500,
  "status": "passed"
});
formatter.before({
  "duration": 401700,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Compensator  Accept Claim and full Liability",
  "description": "",
  "id": "journey-18;compensator--accept-claim-and-full-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "compensator accepts claim and makes full liability without dispute",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the claims acceptance and liability is now sent to the claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 40216042400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_liability_without_dispute()"
});
formatter.result({
  "duration": 95859064400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_full_liability_sent_claimant()"
});
formatter.result({
  "duration": 12459862000,
  "status": "passed"
});
formatter.after({
  "duration": 1747263500,
  "status": "passed"
});
formatter.before({
  "duration": 5444079600,
  "status": "passed"
});
formatter.before({
  "duration": 105200,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Unrep Provides Medical Preferences",
  "description": "",
  "id": "journey-18;unrep-provides-medical-preferences",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "the unrep claim moves to full liability",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "unrep selects medical preferences for an DME",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "medical preferences are sent to Independent Expert",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_full_liability()"
});
formatter.result({
  "duration": 33601288600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.unrep_medical_preference_dme()"
});
formatter.result({
  "duration": 108940030200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.medical_preferences_sent_experts()"
});
formatter.result({
  "duration": 12326977500,
  "status": "passed"
});
formatter.after({
  "duration": 1656551700,
  "status": "passed"
});
formatter.before({
  "duration": 5840967000,
  "status": "passed"
});
formatter.before({
  "duration": 101200,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "DME uploads report-with Wait out prognosis more than twenty four months",
  "description": "",
  "id": "journey-18;dme-uploads-report-with-wait-out-prognosis-more-than-twenty-four-months",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "claimant selects DME",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "DME upload medical report with prognois time",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Report is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "DMEDefs.claimant_selects_dme()"
});
formatter.result({
  "duration": 42425365100,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.dme_upload_medical_report_with_prognosis_time()"
});
formatter.result({
  "duration": 301198621000,
  "status": "passed"
});
formatter.match({
  "location": "DMEDefs.report_is_sent_to_claimant()"
});
formatter.result({
  "duration": 10027126300,
  "status": "passed"
});
formatter.after({
  "duration": 1765810900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 27,
  "name": "Claimant decides to withdraw claim based on threshold message indicating claim can be withdrawn if needed.",
  "description": "",
  "id": "journey-18;claimant-decides-to-withdraw-claim-based-on-threshold-message-indicating-claim-can-be-withdrawn-if-needed.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 28,
  "name": "claimant reviews medical report when uploaded by DME",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "the unrep claimant then decides to withdraw the claim at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "the claimant has withdrawn claim and Compensator to acknowledge this",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "journey-18;claimant-decides-to-withdraw-claim-based-on-threshold-message-indicating-claim-can-be-withdrawn-if-needed.;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 32,
      "id": "journey-18;claimant-decides-to-withdraw-claim-based-on-threshold-message-indicating-claim-can-be-withdrawn-if-needed.;;1"
    },
    {
      "cells": [
        "Pending-CheckMedical"
      ],
      "line": 33,
      "id": "journey-18;claimant-decides-to-withdraw-claim-based-on-threshold-message-indicating-claim-can-be-withdrawn-if-needed.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6504295400,
  "status": "passed"
});
formatter.before({
  "duration": 522300,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Claimant decides to withdraw claim based on threshold message indicating claim can be withdrawn if needed.",
  "description": "",
  "id": "journey-18;claimant-decides-to-withdraw-claim-based-on-threshold-message-indicating-claim-can-be-withdrawn-if-needed.;;2",
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
  "line": 28,
  "name": "claimant reviews medical report when uploaded by DME",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "the unrep claimant then decides to withdraw the claim at \u0027Pending-CheckMedical\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "the claimant has withdrawn claim and Compensator to acknowledge this",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.review_medical_report_uploaded_by_dme()"
});
formatter.result({
  "duration": 36407687000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-CheckMedical",
      "offset": 58
    }
  ],
  "location": "ClaimantActionsStepDefs.unrep_claimant_withdraw_claim(String)"
});
formatter.result({
  "duration": 35783530600,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claimant_withdrawn_claim_compensator_acknowledge()"
});
formatter.result({
  "duration": 12520338200,
  "status": "passed"
});
formatter.after({
  "duration": 1643953700,
  "status": "passed"
});
formatter.before({
  "duration": 5541205100,
  "status": "passed"
});
formatter.before({
  "duration": 158100,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Compensator acknowledges the withdrawl and claim resolved",
  "description": "",
  "id": "journey-18;compensator-acknowledges-the-withdrawl-and-claim-resolved",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Compensator acknowledges claimants withdrawal",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "the claim can be Resolved",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 55099530500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_acknowledges_claimants_withdrawal()"
});
formatter.result({
  "duration": 274379799400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_resolved()"
});
formatter.result({
  "duration": 12550735500,
  "status": "passed"
});
formatter.after({
  "duration": 1718941000,
  "status": "passed"
});
});