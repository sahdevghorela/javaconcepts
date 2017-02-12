package java8.function.consumer;


import java.util.function.Consumer;

public class ConsumerDemo {

    private Consumer<Movie> logMovie = (m) -> System.out.println("Movie with name: "+m);
    private Consumer<Movie> persistMovie = this::persiste;
    private Consumer<Movie> notifyNewMovie = this::notifyNewMovie;

    private void notifyNewMovie(Movie movie) {
        System.out.println("Send notification of new movie "+movie);
    }

    public void composeConsumers(Movie movie){
        Consumer<Movie> chainedConsumers = persistMovie.andThen(logMovie).andThen(notifyNewMovie);
        chainedConsumers.accept(movie);
    }

    private void persiste(Movie movie) {
        System.out.println("Persisting movie "+movie);
    }

    public static void main(String args[]){
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.composeConsumers(new Movie("God must be crazy"));
    }




    private static class Movie{
        private String name;

        public Movie(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
