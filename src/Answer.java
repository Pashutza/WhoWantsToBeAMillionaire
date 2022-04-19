public class Answer {
    private String answer;
    private boolean isTrue;
    private String sequence;

    public Answer(String answer, boolean isTrue, String sequence) {
        this.answer = answer;
        this.isTrue = isTrue;
        this.sequence = sequence;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
