/*
 * package com.brickbuster.service;
 * 
 * import java.time.LocalDate; import java.util.HashSet; import java.util.Set;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * com.brickbuster.entity.Member; import com.brickbuster.entity.Movie; import
 * com.brickbuster.entity.Rental; import com.brickbuster.entity.VideoGame;
 * import com.brickbuster.repository.MemberRepository; import
 * com.brickbuster.repository.MovieRepository; import
 * com.brickbuster.repository.RentalRepository; import
 * com.brickbuster.util.RentalStatus; import
 * com.brickbuster.util.MembershipLevel;
 * 
 * 
 * 
 * 
 * 
 * public class RentalService {
 * 
 * private static final Logger logger =
 * LogManager.getLogger(RentalService.class);
 * 
 * private final int DAYS_UNTIL_DUE = 7;
 * 
 * @Autowired private RentalRepository repo;
 * 
 * @Autowired private MemberRepository memberRepo;
 * 
 * @Autowired private MovieRepository movieRepo;
 * 
 * 
 * public Rental submitNewMovieOrder(Set<Long> movieId, Long memberId) throws
 * Exception { try { Member member = memberRepo.findById(memberId).get(); Rental
 * rental = initializeNewMovieOrder(movieId, member); return repo.save(rental);
 * } catch (Exception e) { logger.
 * error("Exception occurred while trying to create new rental for customer: "+
 * memberId, e); throw e; } }
 * 
 * 
 * private Rental initializeNewMovieOrder(Set<Long> movieId, Member member) {
 * Rental rental = new Rental();
 * rental.setMovies(convertToMovieSet(movieRepo.findAllById(movieId)));
 * rental.setDateDue(LocalDate.now().minusDays(DAYS_UNTIL_DUE));
 * rental.setMembers(member);
 * rental.setInvoiceAmount(calculateMovieTotal(rental.getMovies(),
 * member.getMembershipLevel())); rental.setStatus(RentalStatus.RENTED);
 * addRentalToMovie(rental); return rental; }
 * 
 * private void addRentalToMovie(Rental rental) { Set<Movie> movies =
 * rental.getMovies(); for (Movie movie : movies) {
 * movie.getRentals().add(rental); } }
 * 
 * 
 * private Set<Movie> convertToMovieSet(Iterable<Movie> Id) {
 * 
 * Set<Movie> set = new HashSet<Movie>(); for (Movie movie : Id) {
 * set.add(movie); }
 * 
 * 
 * return null; } private Set<VideoGame>
 * convertToVideoGameSet(Iterable<VideoGame> findAllById) { // TODO
 * Auto-generated method stub return null; }
 * 
 * 
 * public Rental submitNewVideoGameOrder(Set<Long> videoGameId, Long memberId)
 * throws Exception { try { Member member = memberRepo.findById(memberId).get();
 * Rental rental = initializeNewVideoGameOrder(videoGameId, member); return
 * repo.save(rental); } catch (Exception e) { logger.
 * error("Exception occurred while trying to create new rental for customer: "+
 * memberId, e); throw e; } }
 * 
 * 
 * private Rental initializeNewVideoGameOrder(Set<Long> videoGameId, Member
 * member) {
 * 
 * return null; }
 * 
 * 
 * private double calculateMovieTotal(Set<Movie> movies, MembershipLevel level)
 * { double Mtotal = 0; for (Movie movie : movies) { Mtotal += movie.getPrice();
 * }
 * 
 * return Mtotal - Mtotal * level.getDiscount(); }
 * 
 * 
 * // ,Set<VideoGame> videogames, // for (VideoGame videogame : videogames) { //
 * total += videogame.getPrice(); //}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */