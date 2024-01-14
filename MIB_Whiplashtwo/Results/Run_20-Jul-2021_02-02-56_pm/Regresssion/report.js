$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey36.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 36",
  "description": "",
  "id": "journey-36",
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
  "name": "Prouser Submit a Claim as a owner",
  "description": "",
  "id": "journey-36;prouser-submit-a-claim-as-a-owner",
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
  "id": "journey-36;prouser-submit-a-claim-as-a-owner;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 10,
      "id": "journey-36;prouser-submit-a-claim-as-a-owner;;1"
    },
    {
      "cells": [
        "The driver",
        "YES",
        "NO"
      ],
      "line": 11,
      "id": "journey-36;prouser-submit-a-claim-as-a-owner;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8602581800,
  "status": "passed"
});
formatter.before({
  "duration": 221100,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Prouser Submit a Claim as a owner",
  "description": "",
  "id": "journey-36;prouser-submit-a-claim-as-a-owner;;2",
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
  "duration": 44022384200,
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
  "duration": 458928491400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 49089721300,
  "status": "passed"
});
formatter.after({
  "duration": 1755965900,
  "status": "passed"
});
formatter.before({
  "duration": 5993594600,
  "status": "passed"
});
formatter.before({
  "duration": 368100,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-36;compensator-receives-claim-and-claim-liability-sent-to-tpa",
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
  "duration": 36554947800,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 35939325000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10963465000,
  "status": "passed"
});
formatter.after({
  "duration": 1787023200,
  "status": "passed"
});
formatter.before({
  "duration": 5886656300,
  "status": "passed"
});
formatter.before({
  "duration": 91300,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "TPA disputes causation and admits part liability",
  "description": "",
  "id": "journey-36;tpa-disputes-causation-and-admits-part-liability",
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
  "duration": 36431894000,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 98115996400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 10718819800,
  "status": "passed"
});
formatter.after({
  "duration": 2050271100,
  "status": "passed"
});
formatter.before({
  "duration": 6028092200,
  "status": "passed"
});
formatter.before({
  "duration": 223100,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Claimant add losses and documents",
  "description": "",
  "id": "journey-36;claimant-add-losses-and-documents",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "claim liability is accepted",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "claimant update the losses from Loss Tile and upload documents",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "claim will proceed to upload medical reports",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_liability_accepted()"
});
formatter.result({
  "duration": 34951713700,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.add_loss_upload_document()"
});
formatter.result({
  "duration": 99627748200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.proceed_to_upload_medical_reports()"
});
formatter.result({
  "duration": 12999672500,
  "status": "passed"
});
formatter.after({
  "duration": 1661147300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 29,
  "name": "Prouser  uploads medical Report with waitout prognosis",
  "description": "",
  "id": "journey-36;prouser--uploads-medical-report-with-waitout-prognosis",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 30,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives claim",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "prouser uploads the medical report with waitout prognosis \u0027\u003cstatus\u003e\u0027 and decides to waitout",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": "journey-36;prouser--uploads-medical-report-with-waitout-prognosis;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 35,
      "id": "journey-36;prouser--uploads-medical-report-with-waitout-prognosis;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-Medical"
      ],
      "line": 36,
      "id": "journey-36;prouser--uploads-medical-report-with-waitout-prognosis;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5849853800,
  "status": "passed"
});
formatter.before({
  "duration": 80700,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Prouser  uploads medical Report with waitout prognosis",
  "description": "",
  "id": "journey-36;prouser--uploads-medical-report-with-waitout-prognosis;;2",
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
  "name": "\u0027prouser\u0027 receives claim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "prouser uploads the medical report with waitout prognosis \u0027Pending-Medical\u0027 and decides to waitout",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
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
  "duration": 39839535600,
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
  "duration": 148939073000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 9673570500,
  "status": "passed"
});
formatter.after({
  "duration": 1717062600,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "Prouser indicates completion of wait out period and upload new report",
  "description": "",
  "id": "journey-36;prouser-indicates-completion-of-wait-out-period-and-upload-new-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives claim",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "claimant indicates completion of waitout period and upload new report",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 43,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-indicates-completion-of-wait-out-period-and-upload-new-report;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 44,
      "id": "journey-36;prouser-indicates-completion-of-wait-out-period-and-upload-new-report;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 45,
      "id": "journey-36;prouser-indicates-completion-of-wait-out-period-and-upload-new-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5521533400,
  "status": "passed"
});
formatter.before({
  "duration": 83300,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Prouser indicates completion of wait out period and upload new report",
  "description": "",
  "id": "journey-36;prouser-indicates-completion-of-wait-out-period-and-upload-new-report;;2",
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
  "name": "\u0027prouser\u0027 receives claim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "claimant indicates completion of waitout period and upload new report",
  "keyword": "When "
});
formatter.step({
  "line": 41,
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
  "duration": 36725137000,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claimant_decides_to_waitout_and_upload_new_report()"
});
formatter.result({
  "duration": 359643421100,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 10255671800,
  "status": "passed"
});
formatter.after({
  "duration": 1783667200,
  "status": "passed"
});
formatter.before({
  "duration": 5699207000,
  "status": "passed"
});
formatter.before({
  "duration": 92000,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "TPA First Offer to Prouser",
  "description": "",
  "id": "journey-36;tpa-first-offer-to-prouser",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 48,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 49,
  "name": "the TPA makes first offer",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 48657117700,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_makes_first_offer()"
});
formatter.result({
  "duration": 166286460500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21261956600,
  "status": "passed"
});
formatter.after({
  "duration": 1611373500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 52,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-36;prouser-rejects-the-first-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 53,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 56,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-rejects-the-first-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 57,
      "id": "journey-36;prouser-rejects-the-first-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 58,
      "id": "journey-36;prouser-rejects-the-first-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5899314100,
  "status": "passed"
});
formatter.before({
  "duration": 98200,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "Prouser rejects the first offer to Compensator",
  "description": "",
  "id": "journey-36;prouser-rejects-the-first-offer-to-compensator;;2",
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
  "line": 53,
  "name": "\u0027prouser\u0027 receives the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 55,
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
  "location": "ClaimantActionsStepDefs.receives_first_offer(String)"
});
formatter.result({
  "duration": 38299873200,
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
  "duration": 169773282900,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11843788700,
  "status": "passed"
});
formatter.after({
  "duration": 1718545500,
  "status": "passed"
});
formatter.before({
  "duration": 5321517400,
  "status": "passed"
});
formatter.before({
  "duration": 56900,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "TPA reject claimant counter offer and makes new offer(Second offer)",
  "description": "",
  "id": "journey-36;tpa-reject-claimant-counter-offer-and-makes-new-offer(second-offer)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 61,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 62,
  "name": "the TPA send updated offer",
  "keyword": "When "
});
formatter.step({
  "line": 63,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 39745302800,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_send_updated_offer()"
});
formatter.result({
  "duration": 72582341000,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21033037600,
  "status": "passed"
});
formatter.after({
  "duration": 1622203500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 65,
  "name": "Prouser rejects the Second offer to Compensator",
  "description": "",
  "id": "journey-36;prouser-rejects-the-second-offer-to-compensator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 66,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives the offer",
  "keyword": "Given "
});
formatter.step({
  "line": 67,
  "name": "\u0027\u003cclaimant\u003e\u0027 reject the offer",
  "keyword": "When "
});
formatter.step({
  "line": 68,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 69,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-rejects-the-second-offer-to-compensator;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 70,
      "id": "journey-36;prouser-rejects-the-second-offer-to-compensator;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 71,
      "id": "journey-36;prouser-rejects-the-second-offer-to-compensator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5273557600,
  "status": "passed"
});
formatter.before({
  "duration": 49900,
  "status": "passed"
});
formatter.scenario({
  "line": 71,
  "name": "Prouser rejects the Second offer to Compensator",
  "description": "",
  "id": "journey-36;prouser-rejects-the-second-offer-to-compensator;;2",
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
  "line": 66,
  "name": "\u0027prouser\u0027 receives the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 67,
  "name": "\u0027prouser\u0027 reject the offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 68,
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
  "location": "ClaimantActionsStepDefs.receives_first_offer(String)"
});
formatter.result({
  "duration": 38079497300,
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
  "duration": 1169096596100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 12915253100,
  "status": "passed"
});
formatter.after({
  "duration": 1706883200,
  "status": "passed"
});
formatter.before({
  "duration": 5976927800,
  "status": "passed"
});
formatter.before({
  "duration": 219000,
  "status": "passed"
});
formatter.scenario({
  "line": 73,
  "name": "Compensator reject claimant counter offer and makes new offer(third offer)",
  "description": "",
  "id": "journey-36;compensator-reject-claimant-counter-offer-and-makes-new-offer(third-offer)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 74,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "the TPA send updated offer",
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "offer is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 36530633200,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_send_updated_offer()"
});
formatter.result({
  "duration": 72361750100,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.first_offer_claimant()"
});
formatter.result({
  "duration": 21492107000,
  "status": "passed"
});
formatter.after({
  "duration": 1697119700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 78,
  "name": "Prouser rejects offer and goes to court",
  "description": "",
  "id": "journey-36;prouser-rejects-offer-and-goes-to-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 79,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives new offer",
  "keyword": "Given "
});
formatter.step({
  "line": 80,
  "name": "\u0027\u003cclaimant\u003e\u0027 decides to go to court after rejecting offer",
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "counter offer is sent for revision",
  "keyword": "Then "
});
formatter.examples({
  "line": 82,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-rejects-offer-and-goes-to-court;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 83,
      "id": "journey-36;prouser-rejects-offer-and-goes-to-court;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 84,
      "id": "journey-36;prouser-rejects-offer-and-goes-to-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5041044600,
  "status": "passed"
});
formatter.before({
  "duration": 103800,
  "status": "passed"
});
formatter.scenario({
  "line": 84,
  "name": "Prouser rejects offer and goes to court",
  "description": "",
  "id": "journey-36;prouser-rejects-offer-and-goes-to-court;;2",
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
  "line": 79,
  "name": "\u0027prouser\u0027 receives new offer",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 80,
  "name": "\u0027prouser\u0027 decides to go to court after rejecting offer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 81,
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
  "duration": 42168775200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_decides_to_go_to_court(String)"
});
formatter.result({
  "duration": 91024905100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.counter_offer_sent_for_revision()"
});
formatter.result({
  "duration": 11870659800,
  "status": "passed"
});
formatter.after({
  "duration": 1708883100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 86,
  "name": "Prouser goes to court and answer NVC",
  "description": "",
  "id": "journey-36;prouser-goes-to-court-and-answer-nvc",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 87,
  "name": "\u0027\u003cclaimant\u003e\u0027 decided to go to court",
  "keyword": "Given "
});
formatter.step({
  "line": 88,
  "name": "\u0027\u003cclaimant\u003e\u0027 answers NVC questions",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "claim will be sent to compensator to review nvc answers",
  "keyword": "Then "
});
formatter.examples({
  "line": 90,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-goes-to-court-and-answer-nvc;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 91,
      "id": "journey-36;prouser-goes-to-court-and-answer-nvc;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 92,
      "id": "journey-36;prouser-goes-to-court-and-answer-nvc;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5674800400,
  "status": "passed"
});
formatter.before({
  "duration": 203600,
  "status": "passed"
});
formatter.scenario({
  "line": 92,
  "name": "Prouser goes to court and answer NVC",
  "description": "",
  "id": "journey-36;prouser-goes-to-court-and-answer-nvc;;2",
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
  "line": 87,
  "name": "\u0027prouser\u0027 decided to go to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 88,
  "name": "\u0027prouser\u0027 answers NVC questions",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "claim will be sent to compensator to review nvc answers",
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
  "duration": 41967497300,
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
  "duration": 294918130400,
  "status": "passed"
});
formatter.match({
  "location": "MIBProActionsStepDefs.mibprouser_claim_sent_to_compensator_for_review_nvc_answers_mibprouser()"
});
formatter.result({
  "duration": 12762025000,
  "status": "passed"
});
formatter.after({
  "duration": 1791309100,
  "status": "passed"
});
formatter.before({
  "duration": 5151373800,
  "status": "passed"
});
formatter.before({
  "duration": 61800,
  "status": "passed"
});
formatter.scenario({
  "line": 94,
  "name": "TPA agrees the nvc selection",
  "description": "",
  "id": "journey-36;tpa-agrees-the-nvc-selection",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 95,
  "name": "TPA receives claim to review NVC answers",
  "keyword": "Given "
});
formatter.step({
  "line": 96,
  "name": "TPA responds to NVC answers",
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "claim should be sent to claimant to select documents for court",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.tpa_review_nvc_answers()"
});
formatter.result({
  "duration": 40783975600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_respond_nvc_answers()"
});
formatter.result({
  "duration": 41310222400,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claim_sent_to_claimant_to_select_court_document()"
});
formatter.result({
  "duration": 9477309700,
  "status": "passed"
});
formatter.after({
  "duration": 1703010300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 99,
  "name": "prouser Claimant selects documents for court",
  "description": "",
  "id": "journey-36;prouser-claimant-selects-documents-for-court",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 100,
  "name": "Compensator responds NVC answers to \u0027\u003cClaimant\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 101,
  "name": "\u0027\u003cClaimant\u003e\u0027 selects documents for court after NVC",
  "keyword": "When "
});
formatter.step({
  "line": 102,
  "name": "documents should be reviewed by Compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 103,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-claimant-selects-documents-for-court;",
  "rows": [
    {
      "cells": [
        "Claimant"
      ],
      "line": 104,
      "id": "journey-36;prouser-claimant-selects-documents-for-court;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 105,
      "id": "journey-36;prouser-claimant-selects-documents-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5650639000,
  "status": "passed"
});
formatter.before({
  "duration": 152400,
  "status": "passed"
});
formatter.scenario({
  "line": 105,
  "name": "prouser Claimant selects documents for court",
  "description": "",
  "id": "journey-36;prouser-claimant-selects-documents-for-court;;2",
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
  "line": 100,
  "name": "Compensator responds NVC answers to \u0027prouser\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 101,
  "name": "\u0027prouser\u0027 selects documents for court after NVC",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 102,
  "name": "documents should be reviewed by Compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 37
    }
  ],
  "location": "ClaimantActionsStepDefs.compensator_responds_nvc_answers(String)"
});
formatter.result({
  "duration": 54790958600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_upload_court_document_after_nvc(String)"
});
formatter.result({
  "duration": 87884557300,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.document_sent_to_compensator_review()"
});
formatter.result({
  "duration": 11699787100,
  "status": "passed"
});
formatter.after({
  "duration": 1789512000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 107,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-36;tpa-acknowledges-documents-selected-for-court",
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
  "id": "journey-36;tpa-acknowledges-documents-selected-for-court;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 112,
      "id": "journey-36;tpa-acknowledges-documents-selected-for-court;;1"
    },
    {
      "cells": [
        "Pending-OfferListReview"
      ],
      "line": 113,
      "id": "journey-36;tpa-acknowledges-documents-selected-for-court;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5930083300,
  "status": "passed"
});
formatter.before({
  "duration": 22765300,
  "status": "passed"
});
formatter.scenario({
  "line": 113,
  "name": "TPA acknowledges documents selected for court",
  "description": "",
  "id": "journey-36;tpa-acknowledges-documents-selected-for-court;;2",
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
  "duration": 47723539900,
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
  "duration": 3198342056800,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 317194513700,
  "status": "passed"
});
formatter.after({
  "duration": 2328464100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 115,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-36;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved",
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
  "name": "prouser submit the claim for NVC court and select witness at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 118,
  "name": "case is closed at court stage",
  "keyword": "Then "
});
formatter.examples({
  "line": 119,
  "name": "",
  "description": "",
  "id": "journey-36;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 120,
      "id": "journey-36;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-OfferListAccept"
      ],
      "line": 121,
      "id": "journey-36;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8298045900,
  "status": "passed"
});
formatter.before({
  "duration": 361200,
  "status": "passed"
});
formatter.scenario({
  "line": 121,
  "name": "prouser Claimant acknowledges TPA doc selection and case is resolved",
  "description": "",
  "id": "journey-36;prouser-claimant-acknowledges-tpa-doc-selection-and-case-is-resolved;;2",
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
  "name": "prouser submit the claim for NVC court and select witness at \u0027Pending-OfferListAccept\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 118,
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
  "duration": 40891373800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-OfferListAccept\u0027",
      "offset": 62
    }
  ],
  "location": "ProUserActionsStepDefs.claimant_submit_claim_NVC_court_add_witness(String)"
});
formatter.result({
  "duration": 149291165500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_sent_to_prouser_acknowledgement()"
});
formatter.result({
  "duration": 10591700700,
  "status": "passed"
});
formatter.after({
  "duration": 2325355100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 123,
  "name": "The claim is moved to \u0027Resolved-CourtOffer\u0027",
  "description": "",
  "id": "journey-36;the-claim-is-moved-to-\u0027resolved-courtoffer\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 124,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 125,
  "name": "prouser claim goes to dispute at court at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 126,
  "name": "the claim will be resolved at court",
  "keyword": "Then "
});
formatter.examples({
  "line": 127,
  "name": "",
  "description": "",
  "id": "journey-36;the-claim-is-moved-to-\u0027resolved-courtoffer\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 128,
      "id": "journey-36;the-claim-is-moved-to-\u0027resolved-courtoffer\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-CourtOffer"
      ],
      "line": 129,
      "id": "journey-36;the-claim-is-moved-to-\u0027resolved-courtoffer\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7446729700,
  "status": "passed"
});
formatter.before({
  "duration": 160600,
  "status": "passed"
});
formatter.scenario({
  "line": 129,
  "name": "The claim is moved to \u0027Resolved-CourtOffer\u0027",
  "description": "",
  "id": "journey-36;the-claim-is-moved-to-\u0027resolved-courtoffer\u0027;;2",
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
  "line": 124,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 125,
  "name": "prouser claim goes to dispute at court at \u0027Resolved-CourtOffer\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 126,
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
  "duration": 38482768400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Resolved-CourtOffer",
      "offset": 43
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_claim_goes_to_dispute_at_court(String)"
});
formatter.result({
  "duration": 26274926100,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.the_claim_will_resolved_at_court()"
});
formatter.result({
  "duration": 13163948500,
  "status": "passed"
});
formatter.after({
  "duration": 1949058000,
  "status": "passed"
});
});