package techcourse;

public record OrderRequest(
    String[] menuNames,
    int[] quantities
) {

}
