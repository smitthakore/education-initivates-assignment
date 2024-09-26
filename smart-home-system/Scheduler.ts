// Scheduler
import SmartDevice from "./SmartDevice";
class Scheduler {
    private tasks: { device: SmartDevice, time: string, command: string }[] = [];
  
    schedule(device: SmartDevice, time: string, command: string) {
      this.tasks.push({ device, time, command });
      console.log(`Scheduled task: ${command} for device ${device.id} at ${time}`);
    }
  
    getSchedule() {
      return this.tasks.map(task => `Device ${task.device.id} at ${task.time}: ${task.command}`).join('\n');
    }
  }
  
  export default Scheduler;

  