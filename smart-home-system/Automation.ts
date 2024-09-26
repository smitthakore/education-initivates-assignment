  // Automation (trigger-based)
  class Automation {
    private triggers: { condition: () => boolean, action: () => void }[] = [];
  
    addTrigger(condition: () => boolean, action: () => void) {
      this.triggers.push({ condition, action });
    }
  
    evaluateTriggers() {
      this.triggers.forEach(trigger => {
        if (trigger.condition()) {
          trigger.action();
        }
      });
    }
  }

  export default Automation;
