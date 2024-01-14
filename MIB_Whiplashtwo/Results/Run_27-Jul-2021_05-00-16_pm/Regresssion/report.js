$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey25.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 25",
  "description": "",
  "id": "journey-25",
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
  "id": "journey-25;prouser-submit-a-claim-as-passenger-in-bus",
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
  "id": "journey-25;prouser-submit-a-claim-as-passenger-in-bus;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 10,
      "id": "journey-25;prouser-submit-a-claim-as-passenger-in-bus;;1"
    },
    {
      "cells": [
        "The driver",
        "YES",
        "NO"
      ],
      "line": 11,
      "id": "journey-25;prouser-submit-a-claim-as-passenger-in-bus;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11077622700,
  "status": "passed"
});
formatter.before({
  "duration": 407000,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-25;prouser-submit-a-claim-as-passenger-in-bus;;2",
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
  "name": "prouser enter all mandatory details for claim creation as \u0027The driver\u0027 and \u0027YES\u0027 and \u0027NO\u0027",
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
  "duration": 43809032399,
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
  "duration": 477046345600,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 43819586400,
  "status": "passed"
});
formatter.after({
  "duration": 2303044200,
  "status": "passed"
});
formatter.before({
  "duration": 6727126200,
  "status": "passed"
});
formatter.before({
  "duration": 439100,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-25;compensator-receives-claim-and-claim-liability-sent-to-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "compensator receives claim and send to TPA",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "claims acceptance and liability decision is now sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 34160706300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 36385098300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 11257820100,
  "status": "passed"
});
formatter.after({
  "duration": 2160418400,
  "status": "passed"
});
formatter.before({
  "duration": 7319323200,
  "status": "passed"
});
formatter.before({
  "duration": 109600,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "TPA disputes causation and admits part liability",
  "description": "",
  "id": "journey-25;tpa-disputes-causation-and-admits-part-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "TPA accepts full liability",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 36909501400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 97717870000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 11104505800,
  "status": "passed"
});
formatter.after({
  "duration": 1963650100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Prouser  uploads medical Report with waitout prognosis and release report to TPA",
  "description": "",
  "id": "journey-25;prouser--uploads-medical-report-with-waitout-prognosis-and-release-report-to-tpa",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives claim",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "prouser uploads the medical report with waitout prognosis \u0027\u003cstatus\u003e\u0027 and decides to waitout",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 28,
  "name": "",
  "description": "",
  "id": "journey-25;prouser--uploads-medical-report-with-waitout-prognosis-and-release-report-to-tpa;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 29,
      "id": "journey-25;prouser--uploads-medical-report-with-waitout-prognosis-and-release-report-to-tpa;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-Medical"
      ],
      "line": 30,
      "id": "journey-25;prouser--uploads-medical-report-with-waitout-prognosis-and-release-report-to-tpa;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6566112200,
  "status": "passed"
});
formatter.before({
  "duration": 187100,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Prouser  uploads medical Report with waitout prognosis and release report to TPA",
  "description": "",
  "id": "journey-25;prouser--uploads-medical-report-with-waitout-prognosis-and-release-report-to-tpa;;2",
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
  "line": 24,
  "name": "\u0027prouser\u0027 receives claim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "prouser uploads the medical report with waitout prognosis \u0027Pending-Medical\u0027 and decides to waitout",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
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
  "duration": 38537958200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-Medical",
      "offset": 59
    }
  ],
  "location": "ProUserActionsStepDefs.claimant_upload_medical_report(String)"
});
formatter.result({
  "duration": 153802050000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 9621753100,
  "status": "passed"
});
formatter.after({
  "duration": 2132068600,
  "status": "passed"
});
formatter.before({
  "duration": 6117503200,
  "status": "passed"
});
formatter.before({
  "duration": 106300,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Prouser proceeds with offer during prognosis period",
  "description": "",
  "id": "journey-25;prouser-proceeds-with-offer-during-prognosis-period",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "claimant is in prognosis period",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "claimant decides to proceed with offer during prognosis period",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "medical report is uploaded and offer request is sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_is_in_prognosis_period()"
});
formatter.result({
  "duration": 36243963100,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_decides_to_proceed_with_offer_during_prognosis_period()"
});
formatter.result({
  "duration": 108104723500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.uploaded_report_uplift_request_to_compensator()"
});
formatter.result({
  "duration": 12418701600,
  "status": "passed"
});
formatter.after({
  "duration": 1920050500,
  "status": "passed"
});
formatter.before({
  "duration": 6889853200,
  "status": "passed"
});
formatter.before({
  "duration": 219400,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "TPA First Offer to Prouser",
  "description": "",
  "id": "journey-25;tpa-first-offer-to-prouser",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 39,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "the TPA makes first offer",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 43809976100,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_makes_first_offer()"
});
formatter.result({
  "duration": 166602319400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21334113300,
  "status": "passed"
});
formatter.after({
  "duration": 1904462700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 44,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-first-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 45,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives new offer",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 47,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 48,
  "name": "",
  "description": "",
  "id": "journey-25;prouser-rejects-the-first-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 49,
      "id": "journey-25;prouser-rejects-the-first-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 50,
      "id": "journey-25;prouser-rejects-the-first-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5924553000,
  "status": "passed"
});
formatter.before({
  "duration": 69900,
  "status": "passed"
});
formatter.scenario({
  "line": 50,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-first-offer-to-compensator;;2",
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
  "line": 45,
  "name": "\u0027prouser\u0027 receives new offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 47,
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
  "duration": 32623012600,
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
  "duration": 173106247800,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11747163600,
  "status": "passed"
});
formatter.after({
  "duration": 1916457800,
  "status": "passed"
});
formatter.before({
  "duration": 6597640900,
  "status": "passed"
});
formatter.before({
  "duration": 134900,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "TPA reject claimant counter offer and makes new offer(Second offer)",
  "description": "",
  "id": "journey-25;tpa-reject-claimant-counter-offer-and-makes-new-offer(second-offer)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "the TPA send updated offer",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 35834093000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_send_updated_offer()"
});
formatter.result({
  "duration": 75515291000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21229392200,
  "status": "passed"
});
formatter.after({
  "duration": 1694763100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 59,
  "name": "Prouser rejects the second offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-second-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 60,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives new offer",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 63,
  "name": "",
  "description": "",
  "id": "journey-25;prouser-rejects-the-second-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 64,
      "id": "journey-25;prouser-rejects-the-second-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 65,
      "id": "journey-25;prouser-rejects-the-second-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5888683300,
  "status": "passed"
});
formatter.before({
  "duration": 152100,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "Prouser rejects the second offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-second-offer-to-compensator;;2",
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
  "name": "\u0027prouser\u0027 receives new offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 62,
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
  "duration": 39037074600,
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
  "duration": 175219259900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11859100900,
  "status": "passed"
});
formatter.after({
  "duration": 2069806500,
  "status": "passed"
});
formatter.before({
  "duration": 6877852600,
  "status": "passed"
});
formatter.before({
  "duration": 124600,
  "status": "passed"
});
formatter.scenario({
  "line": 68,
  "name": "TPA reject claimant counter offer and makes new offer(Third offer)",
  "description": "",
  "id": "journey-25;tpa-reject-claimant-counter-offer-and-makes-new-offer(third-offer)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 69,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "the TPA send updated offer",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 41529344300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_send_updated_offer()"
});
formatter.result({
  "duration": 74239051200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21274950600,
  "status": "passed"
});
formatter.after({
  "duration": 2020257400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 75,
  "name": "Prouser rejects the third offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-third-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 76,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives new offer",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 79,
  "name": "",
  "description": "",
  "id": "journey-25;prouser-rejects-the-third-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 80,
      "id": "journey-25;prouser-rejects-the-third-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 81,
      "id": "journey-25;prouser-rejects-the-third-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7105858600,
  "status": "passed"
});
formatter.before({
  "duration": 150600,
  "status": "passed"
});
formatter.scenario({
  "line": 81,
  "name": "Prouser rejects the third offer to Compensator",
  "description": "",
  "id": "journey-25;prouser-rejects-the-third-offer-to-compensator;;2",
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
  "name": "\u0027prouser\u0027 receives new offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 78,
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
  "duration": 42942078100,
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
  "duration": 176054106900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 12197928400,
  "status": "passed"
});
formatter.after({
  "duration": 1902276800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 83,
  "name": "TPA decides to withdraw the offer",
  "description": "",
  "id": "journey-25;tpa-decides-to-withdraw-the-offer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 84,
  "name": "TPA has made first offer to claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "TPA withdraws the offer at claim \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 86,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.examples({
  "line": 87,
  "name": "",
  "description": "",
  "id": "journey-25;tpa-decides-to-withdraw-the-offer;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 88,
      "id": "journey-25;tpa-decides-to-withdraw-the-offer;;1"
    },
    {
      "cells": [
        "Pending-RespondCounter"
      ],
      "line": 89,
      "id": "journey-25;tpa-decides-to-withdraw-the-offer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6414309900,
  "status": "passed"
});
formatter.before({
  "duration": 73000,
  "status": "passed"
});
formatter.scenario({
  "line": 89,
  "name": "TPA decides to withdraw the offer",
  "description": "",
  "id": "journey-25;tpa-decides-to-withdraw-the-offer;;2",
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
  "line": 84,
  "name": "TPA has made first offer to claimant",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "TPA withdraws the offer at claim \u0027Pending-RespondCounter\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 86,
  "name": "TPA gets an option to replace the offer",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_has_made_first_offer_to_claimant()"
});
formatter.result({
  "duration": 41533496600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-RespondCounter",
      "offset": 34
    }
  ],
  "location": "TPAStepDefs.tpa_withdraws_the_offer_and_rejects_the_offer(String)"
});
formatter.result({
  "duration": 47199048400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.stpa_gets_an_option_to_replace_the_offer()"
});
formatter.result({
  "duration": 9247407600,
  "status": "passed"
});
formatter.after({
  "duration": 1978727900,
  "status": "passed"
});
formatter.before({
  "duration": 6024316500,
  "status": "passed"
});
formatter.before({
  "duration": 122400,
  "status": "passed"
});
formatter.scenario({
  "line": 92,
  "name": "TPA rejects final offer",
  "description": "",
  "id": "journey-25;tpa-rejects-final-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 93,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 94,
  "name": "final counter offer is reject",
  "keyword": "When "
});
formatter.step({
  "line": 95,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 39577337700,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.reject_final_counter_offer()"
});
formatter.result({
  "duration": 46727203200,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 22492899200,
  "status": "passed"
});
formatter.after({
  "duration": 1985927100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 97,
  "name": "Claimant goes to court to value claim",
  "description": "",
  "id": "journey-25;claimant-goes-to-court-to-value-claim",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 98,
  "name": "\u0027\u003cclaimant\u003e\u0027 decided to go to court",
  "keyword": "Given "
});
formatter.step({
  "line": 99,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court for final offer",
  "keyword": "When "
});
formatter.step({
  "line": 100,
  "name": "Claimant selection to go to court is confirmed",
  "keyword": "Then "
});
formatter.examples({
  "line": 101,
  "name": "",
  "description": "",
  "id": "journey-25;claimant-goes-to-court-to-value-claim;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 102,
      "id": "journey-25;claimant-goes-to-court-to-value-claim;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 103,
      "id": "journey-25;claimant-goes-to-court-to-value-claim;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6177088600,
  "status": "passed"
});
formatter.before({
  "duration": 119000,
  "status": "passed"
});
formatter.scenario({
  "line": 103,
  "name": "Claimant goes to court to value claim",
  "description": "",
  "id": "journey-25;claimant-goes-to-court-to-value-claim;;2",
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
  "line": 98,
  "name": "\u0027prouser\u0027 decided to go to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 99,
  "name": "\u0027prouser\u0027 goes to court for final offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 100,
  "name": "Claimant selection to go to court is confirmed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_go_to_court(String)"
});
formatter.result({
  "duration": 39944566400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_goes_to_coutr_for_final_offer(String)"
});
formatter.result({
  "duration": 33972001900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.go_to_court_confirmed()"
});
formatter.result({
  "duration": 12110003500,
  "status": "passed"
});
formatter.after({
  "duration": 1888723000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 105,
  "name": "Claimant answers NVC",
  "description": "",
  "id": "journey-25;claimant-answers-nvc",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 106,
  "name": "\u0027\u003cclaimant\u003e\u0027 decided to go to court",
  "keyword": "Given "
});
formatter.step({
  "line": 107,
  "name": "\u0027\u003cclaimant\u003e\u0027 answers NVC questions",
  "keyword": "When "
});
formatter.step({
  "line": 108,
  "name": "Acknowledgement will be sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 109,
  "name": "",
  "description": "",
  "id": "journey-25;claimant-answers-nvc;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 110,
      "id": "journey-25;claimant-answers-nvc;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 111,
      "id": "journey-25;claimant-answers-nvc;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7279562300,
  "status": "passed"
});
formatter.before({
  "duration": 69500,
  "status": "passed"
});
formatter.scenario({
  "line": 111,
  "name": "Claimant answers NVC",
  "description": "",
  "id": "journey-25;claimant-answers-nvc;;2",
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
  "line": 106,
  "name": "\u0027prouser\u0027 decided to go to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 107,
  "name": "\u0027prouser\u0027 answers NVC questions",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 108,
  "name": "Acknowledgement will be sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_go_to_court(String)"
});
formatter.result({
  "duration": 35038447200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_answers_nvc_questions(String)"
});
formatter.result({
  "duration": 136863109000,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.ack_sent_to_compensator()"
});
formatter.result({
  "duration": 368402031100,
  "status": "passed"
});
formatter.after({
  "duration": 2003660700,
  "status": "passed"
});
formatter.before({
  "duration": 6854933800,
  "status": "passed"
});
formatter.before({
  "duration": 19237100,
  "status": "passed"
});
formatter.scenario({
  "line": 114,
  "name": "Compensator removes the claim from portal",
  "description": "",
  "id": "journey-25;compensator-removes-the-claim-from-portal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 115,
  "name": "TPA does not respond to NVC",
  "keyword": "Given "
});
formatter.step({
  "line": 116,
  "name": "TPA removes the claim from portal",
  "keyword": "When "
});
formatter.step({
  "line": 117,
  "name": "the claim is removed from portal and closed",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_does_not_respond_nvc()"
});
formatter.result({
  "duration": 37358289800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_terminates_the_claim()"
});
formatter.result({
  "duration": 1110969436400,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_removed_from_portal()"
});
formatter.result({
  "duration": 10844655400,
  "status": "passed"
});
formatter.after({
  "duration": 2005576800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 119,
  "name": "The claim is moved to \u0027Resolved-Removed\u0027",
  "description": "",
  "id": "journey-25;the-claim-is-moved-to-\u0027resolved-removed\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 120,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 121,
  "name": "prouser claim goes to dispute at court at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 122,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.examples({
  "line": 123,
  "name": "",
  "description": "",
  "id": "journey-25;the-claim-is-moved-to-\u0027resolved-removed\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 124,
      "id": "journey-25;the-claim-is-moved-to-\u0027resolved-removed\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-Removed"
      ],
      "line": 125,
      "id": "journey-25;the-claim-is-moved-to-\u0027resolved-removed\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7228577700,
  "status": "passed"
});
formatter.before({
  "duration": 376300,
  "status": "passed"
});
formatter.scenario({
  "line": 125,
  "name": "The claim is moved to \u0027Resolved-Removed\u0027",
  "description": "",
  "id": "journey-25;the-claim-is-moved-to-\u0027resolved-removed\u0027;;2",
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
  "line": 120,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 121,
  "name": "prouser claim goes to dispute at court at \u0027Resolved-Removed\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 122,
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
  "duration": 46761267100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Resolved-Removed",
      "offset": 43
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_claim_goes_to_dispute_at_court(String)"
});
formatter.result({
  "duration": 31574676400,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 11741442300,
  "status": "passed"
});
formatter.after({
  "duration": 2022389100,
  "status": "passed"
});
});