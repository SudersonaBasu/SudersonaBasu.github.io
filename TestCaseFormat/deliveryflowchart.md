
# 📊 High and Detailed Test Set – Decision Flow

```mermaid
flowchart TD
    A[Start: Active Connection Point] --> B{Action Type}

    %% Branch A: Pause
    B --> C[Pause Sending/Receiving]
    C --> C1[Precondition: CP type = Infor App/ERP LN, Status = Active, Connector OK/ERROR]
    C --> C2[Navigate to Manage > Active CPs]
    C2 --> C3[Columns 'Sending Paused' & 'Receiving Paused' visible]
    C3 --> C4{Pause Action}
    C4 -->|Sending Paused OK| C5[Pause button → Resume, Outbox polling stops, Counters freeze]
    C4 -->|Sending Paused ERROR| C6[Pause results in Error]
    C4 -->|Refresh Pending| C7[Status remains Pending until messages complete]
    C4 -->|Restart IONService| C8[CP remains Paused after restart]
    C4 -->|Pause + Deactivate| C9[CP not visible in Manage screen]
    C4 -->|Pause + Deactivate + Activate| C10[CP still Paused, Resume possible]
    C4 -->|Receiving Paused OK| C11[Inbox frozen, Pending increases, other counters unaffected]
    C4 -->|Receiving Paused drill-down| C12[No change in Pending, messages deletable]
    C4 -->|Receiving Paused threshold| C13[Alert triggered to Administrator]
    C4 -->|Special ERPLN/JDBC flows| C14[Running messages processed, new requests stopped]

    %% Branch B: Resume
    B --> D[Resume Sending/Receiving]
    D --> D1[Precondition: CP already Paused]
    D --> D2[Click Resume → Status Pending, Resume disabled]
    D2 --> D3{Resume Outcome}
    D3 -->|Sending| D4[Outbox resumes, counters increase]
    D3 -->|Receiving| D5[Pending queue cleared, Inbox resumes, counters increase]

    %% Branch C: Status Overview
    B --> E[Status Overview]
    E --> E1[Precondition: CP already Paused]
    E --> E2[Navigate to Manage > Overview]
    E2 --> E3[Paused CP count displayed, Warning icon if >0]

    %% Branch D: Paused Active Documents
    B --> F[Paused Active Documents]
    F --> F1[Navigate to Manage > Active Document Flows]
    F1 --> F2[Details show 'Sending Paused' & 'Receiving Paused' checkboxes]
    F2 --> F3[Status section reflects Paused state]
