 # Example curl scripts for Flowable REST endpoints

 This folder contains small, runnable shell scripts that call the Flowable REST endpoints used by the tests.

 Usage:

 - Make scripts executable:

   chmod +x examples/*.sh

 - Optionally set BASE_URL environment variable (default: http://localhost:8080):

   export BASE_URL=http://localhost:8080

 - Run any script, e.g.:

   ./examples/start_process.sh

 Notes:

 - Scripts prefer `jq` for pretty JSON output if it's installed; otherwise they print raw response bodies.
 - Some scripts require replacing placeholder ids such as `{id}` or `{taskId}` with real values.

 Files:

 - start_process.sh — start a process instance
 - query_tasks.sh — query tasks (by process instance id)
 - complete_task.sh — complete a task (by id)
 - set_variables.sh — set process instance variables (by id)
 - correlate_message.sh — correlate a message (by execution id)
 - evaluate_decision.sh — execute a DMN decision
 - start_case.sh — start a CMMN case instance
